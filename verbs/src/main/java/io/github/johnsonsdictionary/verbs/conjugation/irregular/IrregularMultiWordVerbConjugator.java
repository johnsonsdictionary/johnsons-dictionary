package io.github.johnsonsdictionary.verbs.conjugation.irregular;

import io.github.johnsonsdictionary.dictionary.core.words.WordDefinition;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinitionId;
import io.github.johnsonsdictionary.verbs.EnglishWordsEnGB;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugation;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugator;

import java.util.SortedMap;

public class IrregularMultiWordVerbConjugator implements VerbConjugator<VerbConjugation> {

    private SortedMap<WordDefinitionId, IrregularVerbConjugation> conjugations;

    public IrregularMultiWordVerbConjugator(SortedMap<WordDefinitionId, IrregularVerbConjugation> conjugations) {
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
