package io.github.johnsonsdictionary.verbs.conjugation.regular;

import io.github.johnsonsdictionary.dictionary.core.words.WordDefinition;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinitionId;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugation;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugator;
import io.github.johnsonsdictionary.verbs.conjugation.irregular.IrregularVerbConjugation;

import java.util.SortedMap;

public class RegularMultiWordVerbConjugator implements VerbConjugator<VerbConjugation> {

    private SortedMap<WordDefinitionId, RegularVerbConjugation> conjugations;

    public RegularMultiWordVerbConjugator(SortedMap<WordDefinitionId, RegularVerbConjugation> conjugations) {
        this.conjugations = conjugations;
    }

    @Override
    public VerbConjugation getConjugatedVerb(WordDefinition verbDefinition) {
        VerbConjugation verbConjugation = conjugations.get(verbDefinition.getWordDefinitionId());
        if (verbConjugation == null) {
            throw new IllegalArgumentException("No conjugation found for verb definition:" + verbDefinition);
        } else {
            return verbConjugation;
        }
    }
}
