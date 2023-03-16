package io.github.johnsonsdictionary.verbs.conjugation.contraction;

import io.github.johnsonsdictionary.verbs.tenses.Tense;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugation;
import io.github.johnsonsdictionary.verbs.conjugation.subjects.SubjectType;

import java.util.ArrayList;
import java.util.List;

public class ContractionVerbConjugationDecorator implements VerbConjugation {

    private VerbConjugation decorated;

    public ContractionVerbConjugationDecorator(VerbConjugation decorated) {
        this.decorated = decorated;
    }

    @Override
    public String getVerb() {
        return decorated.getVerb();
    }

    @Override
    public boolean isModelVerb() {
        return decorated.isModelVerb();
    }

    @Override
    public int getMeaningId() {
        return decorated.getMeaningId();
    }

    @Override
    public List<String> getPastTenses(SubjectType subjectType) {
        return decorated.getPastTenses(subjectType);
    }

    private List<String> getAdditionalContractions(List<String> sentences) {
        List<String> results = new ArrayList<>();
        results.addAll(sentences);
        for (String sentence : sentences) {
            if (sentence.contains("will") || sentence.contains("had") || sentence.contains("have") || sentence.contains("is") || sentence.contains("are")) {
                // Temporary - TODO
                // Drop the wi
                sentence = sentence.replace("You will", "You'll");

                // Drop the ha
                sentence = sentence.replace("You had", "You'd");

                // Drop the ha
                sentence = sentence.replace("You have", "You've");

                // Drop the a
                sentence = sentence.replace("You are", "You're");

                // Drop the wi
                sentence = sentence.replace("They will", "They'll");

                // Drop the ha
                sentence = sentence.replace("They had", "They'd");

                // Drop the ha
                sentence = sentence.replace("They have", "They've");

                // Drop the a
                sentence = sentence.replace("They are", "They're");

                // Drop the wi
                sentence = sentence.replace("I will", "I'll");

                // Drop the ha
                sentence = sentence.replace("I had", "I'd");

                // Drop the ha for first person singular
                sentence = sentence.replace("I have", "I've");

                // Drop the a for first person singular to be
                sentence = sentence.replace("I am", "I'm");

                sentence = sentence.replace("I will", "I'll");

                // Drop the ha
                sentence = sentence.replace("I had", "I'd");

                // Drop the ha for first person singular
                sentence = sentence.replace("I have", "I've");

                // Drop the a for first person singular to be
                sentence = sentence.replace("I am", "I'm");


                sentence = sentence.replace("We will", "We'll");

                // Drop the ha
                sentence = sentence.replace("We had", "We'd");

                // Drop the ha for first person singular
                sentence = sentence.replace("We have", "We've");

                // Drop the a for first person singular to be
                sentence = sentence.replace("We are", "We're");


                // Drop the wi for third person singular will modal verb
                sentence = sentence.replace("He will", "He'll");

                // Drop the ha for third person singular to have
                sentence = sentence.replace("He had", "He'd");

                // Drop the ha for third person singular to have
                sentence = sentence.replace("He has", "He's");

                // Drop the i, for third person singular to be
                sentence = sentence.replace("He is", "He's");
                results.add(sentence);
            }
        }
        return results;
    }

    @Override
    public List<String> getPastParticiples() {
        return decorated.getPastParticiples();
    }

    @Override
    public List<String> getPresentParticiples() {
        return decorated.getPresentParticiples();
    }

    @Override
    public String getPresentTense(SubjectType subjectType) {
        return decorated.getPresentTense(subjectType);
    }

    @Override
    public List<String> conjugateVerb(SubjectType subjectType, Tense tense, boolean verbOnly) {
        return getAdditionalContractions(decorated.conjugateVerb(subjectType, tense, verbOnly));
    }

    @Override
    public List<String> conjugateVerb(String subjectName, SubjectType subjectType, Tense tense) {
        return getAdditionalContractions(decorated.conjugateVerb(subjectName, subjectType, tense));
    }
}
