package io.github.johnsonsdictionary.verbs.conjugation.irregular;

import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugation;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugationBaseParent;
import io.github.johnsonsdictionary.verbs.conjugation.subjects.SubjectType;

import java.util.Arrays;
import java.util.List;

public class QuothModalVerbConjugation extends VerbConjugationBaseParent implements VerbConjugation {
    @Override
    public String getVerb() {
        return "quoth";
    }

    @Override
    public boolean isModelVerb() {
        return true;
    }

    @Override
    public int getMeaningId() {
        return 1;
    }

    @Override
    public List<String> getPastTenses(SubjectType subjectType) {
        return Arrays.asList("quoth");
    }

    @Override
    public List<String> getPastParticiples() {
        throw new UnsupportedOperationException("No part participles defined for this verb:" + getVerb());
    }

    @Override
    public List<String> getPresentParticiples() {
        throw new UnsupportedOperationException("No present participles defined for this verb:" + getVerb());
    }

    @Override
    public List<SubjectType> getSupportedSubjectTypes() {
        return Arrays.asList(SubjectType.FIRST_PERSON_SINGULAR, SubjectType.THIRD_PERSON_SINGULAR);
    }

    @Override
    public boolean isSubjectSuffixed() {
        return true;
    }

    @Override
    public String getPresentTense(SubjectType subjectType) {
        return "quoth";
    }
}
