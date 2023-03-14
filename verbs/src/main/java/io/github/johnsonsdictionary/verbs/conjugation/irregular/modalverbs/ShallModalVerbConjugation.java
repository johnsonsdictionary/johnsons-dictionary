package io.github.johnsonsdictionary.verbs.conjugation.irregular.modalverbs;

import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugation;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugationBaseParent;
import io.github.johnsonsdictionary.verbs.conjugation.subjects.SubjectType;

import java.util.Arrays;
import java.util.List;

public class ShallModalVerbConjugation extends VerbConjugationBaseParent implements VerbConjugation {
    @Override
    public String getVerb() {
        return "shall";
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
        if (SubjectType.SECOND_PERSON_SINGULAR.equals(subjectType)) {
            return Arrays.asList("shalt");
        } else {
            return Arrays.asList("shall");
        }
    }

    @Override
    public List<String> getPastParticiples() {
        throw new UnsupportedOperationException("No part participles defined for this modal verb:" + getVerb());
    }

    @Override
    public List<String> getPresentParticiples() {
        throw new UnsupportedOperationException("No present participles defined for this modal verb:" + getVerb());
    }

    @Override
    public String getPresentTense(SubjectType subjectType) {
        if (SubjectType.SECOND_PERSON_SINGULAR.equals(subjectType)) {
            return "shalt";
        } else {
            return "shall";
        }
    }
}
