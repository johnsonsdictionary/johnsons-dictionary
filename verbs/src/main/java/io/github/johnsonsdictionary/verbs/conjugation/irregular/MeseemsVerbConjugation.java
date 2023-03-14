package io.github.johnsonsdictionary.verbs.conjugation.irregular;

import io.github.johnsonsdictionary.verbs.tenses.Tense;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugation;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugationBaseParent;
import io.github.johnsonsdictionary.verbs.conjugation.subjects.SubjectType;

import java.util.Arrays;
import java.util.List;

public class MeseemsVerbConjugation extends VerbConjugationBaseParent implements VerbConjugation {
    @Override
    public String getVerb() {
        return "meseems";
    }

    @Override
    public boolean isModelVerb() {
        return false;
    }

    @Override
    public List<Tense> getSupportedTenses() {
        return Arrays.asList(Tense.PAST_SIMPLE, Tense.PRESENT_SIMPLE);
    }

    @Override
    public List<SubjectType> getSupportedSubjectTypes() {
        return Arrays.asList(SubjectType.NONE);
    }

    @Override
    public int getMeaningId() {
        return 1;
    }

    @Override
    public boolean hasPresentParticiples() {
        return false;
    }

    @Override
    public List<String> getPastTenses(SubjectType subjectType) {
        return Arrays.asList("meseemed");
    }

    @Override
    public boolean hasPastParticiples() {
        return false;
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
    public String getPresentTense(SubjectType subjectType) {
        return "meseems";
    }
}
