package io.github.johnsonsdictionary.verbs.conjugation.contraction;

import io.github.johnsonsdictionary.dictionary.core.words.WordDefinition;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugator;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugation;

public class ContractionVerbConjugatorDecorator<C extends VerbConjugation> implements VerbConjugator {

    private VerbConjugator<C> decorated;

    public ContractionVerbConjugatorDecorator(VerbConjugator<C> decorated) {
        this.decorated = decorated;
    }

    @Override
    public VerbConjugation getConjugatedVerb(WordDefinition verbDefinition) {
        return new ContractionVerbConjugationDecorator(decorated.getConjugatedVerb(verbDefinition));
    }
}
