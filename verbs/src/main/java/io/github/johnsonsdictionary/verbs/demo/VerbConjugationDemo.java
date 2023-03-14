package io.github.johnsonsdictionary.verbs.demo;

import io.github.johnsonsdictionary.dictionary.core.words.WordDefinition;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugators;
import io.github.johnsonsdictionary.verbs.EnglishWordsEnGB;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugation;
import io.github.johnsonsdictionary.verbs.conjugation.subjects.SubjectType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class VerbConjugationDemo {

    public static void main(String[] args) {

        // Add all verb-related words (so far) to a list, and then remove duplicates
        List<String> verbRelatedWords = new ArrayList<>();
        for (WordDefinition wd : EnglishWordsEnGB.ALL_REGULAR_VERBS.values()) {
            VerbConjugation regularVerbConjugation = VerbConjugators.REGULAR_VERB_CONJUGATOR.getConjugatedVerb(wd);
            verbRelatedWords.add(wd.getWord());
            verbRelatedWords.addAll(regularVerbConjugation.getPresentParticiples());
            for (SubjectType subjectType : regularVerbConjugation.getSupportedSubjectTypes()) {
                verbRelatedWords.addAll(regularVerbConjugation.getPastTenses(subjectType));
                verbRelatedWords.add(regularVerbConjugation.getPresentTense(subjectType));
            }
        }

        for (WordDefinition wd : EnglishWordsEnGB.ALL_IRREGULAR_VERBS.values()) {
            VerbConjugation iRegularVerbConjugation = VerbConjugators.IRREGULAR_VERB_CONJUGATOR.getConjugatedVerb(wd);
            verbRelatedWords.add(wd.getWord());
            if (!iRegularVerbConjugation.isModelVerb()) {
                verbRelatedWords.addAll(iRegularVerbConjugation.getPresentParticiples());
                verbRelatedWords.addAll(iRegularVerbConjugation.getPastParticiples());
            }
            for (SubjectType subjectType : iRegularVerbConjugation.getSupportedSubjectTypes()) {
                verbRelatedWords.addAll(iRegularVerbConjugation.getPastTenses(subjectType));
                verbRelatedWords.add(iRegularVerbConjugation.getPresentTense(subjectType));
            }
        }
        verbRelatedWords = verbRelatedWords.stream().distinct().collect(Collectors.toList());
        Collections.sort(verbRelatedWords);
        System.out.println("Number of verb related words so far:" + verbRelatedWords.size());
    }
}
