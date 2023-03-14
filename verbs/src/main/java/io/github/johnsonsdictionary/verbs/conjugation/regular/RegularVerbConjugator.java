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
package io.github.johnsonsdictionary.verbs.conjugation.regular;

import io.github.johnsonsdictionary.dictionary.core.words.WordDefinition;
import io.github.johnsonsdictionary.verbs.EnglishWordsEnGB;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugationLogic;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugator;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugation;

/**
 * Default implementation for regular verb conjugation service.
 *
 * @author Michael Lavelle
 */
public class RegularVerbConjugator implements VerbConjugator<VerbConjugation> {

    @Override
    public VerbConjugation getConjugatedVerb(WordDefinition verbDefinition) {
        String pastTense = VerbConjugationLogic.getPastTenseForRegularVerb(EnglishWordsEnGB.ALL_WORDS, verbDefinition);
        String presentParticiple = VerbConjugationLogic.getPresentParticiple(EnglishWordsEnGB.ALL_WORDS, verbDefinition);
        return new RegularVerbConjugation(verbDefinition.getWord(), verbDefinition.getWordDefinitionId().getMeaningId(), pastTense, presentParticiple);
    }
}
