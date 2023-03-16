/*
 * Copyright 2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package io.github.johnsonsdictionary.verbs.conjugation.irregular;

import io.github.johnsonsdictionary.dictionary.core.words.WordDefinition;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinitionId;
import io.github.johnsonsdictionary.verbs.EnglishWordsEnGB;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugationLogic;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugator;
import io.github.johnsonsdictionary.verbs.conjugation.irregular.modalverbs.*;
import io.github.johnsonsdictionary.verbs.conjugation.specialcases.SpecialCaseVerbConjugations;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugation;
import io.github.johnsonsdictionary.verbs.conjugation.util.VerbConjugationCSVReader;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Default implementation for irregular verb conjugation service.
 *
 * @author Michael Lavelle
 */
public class IrregularVerbConjugator implements VerbConjugator<VerbConjugation> {

    private Map<WordDefinitionId, IrregularVerbConjugation> conjugations;

    public IrregularVerbConjugator(List<String> verbDefinitionFiles) {
        this.conjugations = new VerbConjugationCSVReader<>((i, v) ->
                new IrregularVerbConjugation(v.get(0), i.getMeaningId(), getValuesFromVariables(v, "past_tense", false), getValuesFromVariables(v, "past_participle", false), getValuesFromVariables(v, "present_participle", true)),
                false, verbDefinitionFiles).load();
    }

    private List<String> getValuesFromVariables(List<String> csvVariables, String key, boolean required) {
        String prefix = key + "=";
        List<String> candidates = csvVariables.stream().filter(v -> v.startsWith(prefix)).collect(Collectors.toList());
        if (required && candidates.isEmpty()) {
            throw new IllegalStateException("No value defined for key:" + key + " within:" + csvVariables);
        } else {
            return candidates.stream().map(v -> v.substring(prefix.length())).collect(Collectors.toList());
        }
    }

    @Override
    public VerbConjugation getConjugatedVerb(WordDefinition verbDefinition) {
        if (verbDefinition.getWordDefinitionId().equals(WordDefinitionId.create("be", 1))) {
            return new ToBeVerbConjugation();
        } else {
            if (verbDefinition.getWordDefinitionId().equals(SpecialCaseVerbConjugations.WILL_MODAL_VERB_DEFINTION.getWordDefinitionId())) {
                return new WillModalVerbConjugation();
            } else if (verbDefinition.getWordDefinitionId().equals(SpecialCaseVerbConjugations.SHALL_MODAL_VERB_DEFINTION.getWordDefinitionId())) {
                return new ShallModalVerbConjugation();
            } else if (verbDefinition.getWordDefinitionId().equals(SpecialCaseVerbConjugations.OUGHT_MODAL_VERB_DEFINTION.getWordDefinitionId())) {
                return new OughtModalVerbConjugation();
            } else if (verbDefinition.getWordDefinitionId().equals(SpecialCaseVerbConjugations.QUOTH_VERB_DEFINTION.getWordDefinitionId())) {
                return new QuothModalVerbConjugation();
            } else if (verbDefinition.getWordDefinitionId().equals(SpecialCaseVerbConjugations.METHINKS_VERB_DEFINTION.getWordDefinitionId())) {
                return new MethinksVerbConjugation();
            } else if (verbDefinition.getWordDefinitionId().equals(SpecialCaseVerbConjugations.CAN_MODAL_VERB_DEFINTION.getWordDefinitionId())) {
                return new CanModalVerbConjugation();
            } else if (verbDefinition.getWordDefinitionId().equals(SpecialCaseVerbConjugations.MAY_MODAL_VERB_DEFINTION.getWordDefinitionId())) {
                return new MayModalVerbConjugation();
            } else if (verbDefinition.getWordDefinitionId().equals(SpecialCaseVerbConjugations.SHOULD_MODAL_VERB_DEFINTION.getWordDefinitionId())) {
                return new ShouldModalVerbConjugation();
            } else if (verbDefinition.getWordDefinitionId().equals(SpecialCaseVerbConjugations.MESEEMS_VERB_DEFINTION.getWordDefinitionId())) {
                return new MeseemsVerbConjugation();
            }
        }
        IrregularVerbConjugation matched = conjugations.get(verbDefinition.getWordDefinitionId());

        String presentParticiple = VerbConjugationLogic.getPresentParticiple(EnglishWordsEnGB.ALL_WORDS, verbDefinition);
        if (matched == null) {
            throw new IllegalStateException("Unable to calculate present participle for:" + verbDefinition.getWordDefinitionId());
        }
        if (matched.getPresentParticiples().size() > 1) {
            throw new UnsupportedOperationException("Multiple present participles not yet supported");
        } else if (matched.getPresentParticiples().isEmpty()) {
            throw new IllegalStateException("Unable to calculate present participle for:" + verbDefinition.getWordDefinitionId());
        } else {
            if (!matched.getPresentParticiples().get(0).equals(presentParticiple)) {
                throw new IllegalStateException("Calculated present participle does not match defined present participle:" + verbDefinition.getWordDefinitionId() + ":" + matched.getPresentParticiples().get(0) + ":" + presentParticiple);
            }
        }
        return matched;
    }
}
