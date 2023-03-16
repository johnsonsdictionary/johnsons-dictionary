package io.github.johnsonsdictionary.verbs.demo.examples;

import io.github.johnsonsdictionary.dictionary.core.words.WordDefinitionId;
import io.github.johnsonsdictionary.verbs.EnglishWordsEnGB;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugators;
import io.github.johnsonsdictionary.verbs.conjugation.subjects.SubjectType;
import io.github.johnsonsdictionary.verbs.tenses.Tense;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ToGoVerbConjugationDemo {

    public static void main(String[] args) {

        // Add all verb-related words (so far) to a list, and then remove duplicates
        List<String> verbRelatedWords = new ArrayList<>();

        VerbConjugation iRegularVerbConjugation = VerbConjugators.IRREGULAR_VERB_CONJUGATOR.getConjugatedVerb(EnglishWordsEnGB.ALL_IRREGULAR_VERBS.get(WordDefinitionId.create("go", 1)));

        verbRelatedWords.add(iRegularVerbConjugation.getVerb());
        verbRelatedWords.addAll(iRegularVerbConjugation.getPresentParticiples());
        verbRelatedWords.addAll(iRegularVerbConjugation.getPastParticiples());
        for (SubjectType subjectType : iRegularVerbConjugation.getSupportedSubjectTypes()) {
            verbRelatedWords.addAll(iRegularVerbConjugation.getPastTenses(subjectType));
            verbRelatedWords.add(iRegularVerbConjugation.getPresentTense(subjectType));
            for (Tense tense : iRegularVerbConjugation.getSupportedTenses()) {
                List<String> conjugations = iRegularVerbConjugation.conjugateVerb(getDefaultSubjectName(subjectType), subjectType, tense);
                System.out.println(tense + ":" + subjectType + ":" + conjugations);
            }
        }
        verbRelatedWords = verbRelatedWords.stream().distinct().collect(Collectors.toList());
        Collections.sort(verbRelatedWords);
        System.out.println("Verb related words:" + verbRelatedWords);
    }

    private static String getDefaultSubjectName(SubjectType subjectType) {
        if (SubjectType.FIRST_PERSON_SINGULAR.equals(subjectType)) {
            return "I";
        } else if (SubjectType.FIRST_PERSON_PLURAL.equals(subjectType)) {
            return "We";
        } else if (SubjectType.SECOND_PERSON_SINGULAR.equals(subjectType)) {
            return "You";
        } else if (SubjectType.SECOND_PERSON_PLURAL.equals(subjectType)) {
            return "You";
        } else if (SubjectType.THIRD_PERSON_SINGULAR.equals(subjectType)) {
            return "He";
        } else if (SubjectType.THIRD_PERSON_PLURAL.equals(subjectType)) {
            return "They";
        } else {
            throw new IllegalArgumentException("Unknown subject type:" + subjectType);
        }
    }
}
