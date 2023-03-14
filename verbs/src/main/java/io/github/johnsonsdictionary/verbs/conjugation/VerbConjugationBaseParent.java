package io.github.johnsonsdictionary.verbs.conjugation;

import io.github.johnsonsdictionary.verbs.conjugation.specialcases.SpecialCaseVerbConjugations;
import io.github.johnsonsdictionary.verbs.conjugation.subjects.SubjectType;
import io.github.johnsonsdictionary.verbs.tenses.Tense;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class VerbConjugationBaseParent implements VerbConjugation{


    @Override
    public List<String> conjugateVerb(String subjectName, SubjectType subjectType, Tense tense) {
        if (SubjectType.NONE.equals(subjectType)) {
            return conjugateVerb(subjectType, tense, true).stream().collect(Collectors.toList());
        } else {
            if (isSubjectSuffixed()) {
                return conjugateVerb(subjectType, tense, false).stream().map(w -> w + " " + subjectName).collect(Collectors.toList());
            } else {
                return conjugateVerb(subjectType, tense, false).stream().map(w -> subjectName + " " + w).collect(Collectors.toList());
            }
        }
    }

    @Override
    public List<String> conjugateVerb(SubjectType subjectType, Tense tense, boolean verbOnly) {
        if (Tense.PRESENT_SIMPLE.equals(tense)) {
            return Arrays.asList(getPresentTense(subjectType));
        } else if (Tense.PRESENT_PERFECT.equals(tense)){
            if (!verbOnly) {
                List<String> haveConjugations = SpecialCaseVerbConjugations.TO_HAVE_VERB_CONJUGATION.conjugateVerb(subjectType, Tense.PRESENT_SIMPLE, true);
                if (haveConjugations.size() != 1) {
                    throw new UnsupportedOperationException("Must be exactly one conjugation of to have for this subject type and tense");
                } else {
                    String haveConjugation = haveConjugations.get(0);
                    return getPastParticiples().stream().map(w -> haveConjugation + " " + w).collect(Collectors.toList());
                }
            }
            return getPastParticiples();
        } else if (Tense.PRESENT_PERFECT_CONTINUOUS.equals(tense)){
            if (!verbOnly) {
                List<String> haveConjugations = SpecialCaseVerbConjugations.TO_HAVE_VERB_CONJUGATION.conjugateVerb(subjectType, Tense.PRESENT_SIMPLE, true);
                if (haveConjugations.size() != 1) {
                    throw new UnsupportedOperationException("Must be exactly one conjugation of to have for this subject type and tense");
                } else {
                    String haveConjugation = haveConjugations.get(0);
                    List<String> bePastParticiples = SpecialCaseVerbConjugations.TO_BE_VERB_CONJUGATION.getPastParticiples();
                    if (bePastParticiples.size() != 1) {
                        throw new UnsupportedOperationException("Must be exactly one past participle of to be for this subject type and tense");
                    } else {
                        return getPresentParticiples().stream().map(w -> haveConjugation + " " + bePastParticiples.get(0) + " " + w).collect(Collectors.toList());
                    }
                }
            }
            return getPastParticiples();
        }else if (Tense.PRESENT_CONTINUOUS.equals(tense)){
            if (!verbOnly) {
                List<String> beConjugations = SpecialCaseVerbConjugations.TO_BE_VERB_CONJUGATION.conjugateVerb(subjectType, Tense.PRESENT_SIMPLE, true);
                if (beConjugations.size() != 1) {
                    throw new UnsupportedOperationException("Must be exactly one conjugation of to be for this subject type and tense");
                } else {
                    String beConjugation = beConjugations.get(0);
                    return getPresentParticiples().stream().map(w -> beConjugation + " " + w).collect(Collectors.toList());
                }
            }
            return getPastParticiples();
        } else   if (Tense.FUTURE_SIMPLE.equals(tense)) {
            return Arrays.asList(SpecialCaseVerbConjugations.WILL_MODEL_VERB_CONJUGATION.conjugateVerb(subjectType, Tense.PRESENT_SIMPLE, true).get(0) + " " + getVerb());
        } else if (Tense.FUTURE_PERFECT.equals(tense)){
            if (!verbOnly) {
                String haveInfinitive = SpecialCaseVerbConjugations.TO_HAVE_VERB_CONJUGATION.getVerb();
                return getPastParticiples().stream().map(w -> SpecialCaseVerbConjugations.WILL_MODEL_VERB_CONJUGATION.conjugateVerb(subjectType, Tense.PRESENT_SIMPLE, true).get(0)  + " " + haveInfinitive + " " + w).collect(Collectors.toList());
            }
            return getPastParticiples();
        } else if (Tense.FUTURE_PERFECT_CONTINUOUS.equals(tense)){
            if (!verbOnly) {
                List<String> haveConjugations = SpecialCaseVerbConjugations.TO_HAVE_VERB_CONJUGATION.conjugateVerb(subjectType, Tense.PRESENT_SIMPLE, true);
                if (haveConjugations.size() != 1) {
                    throw new UnsupportedOperationException("Must be exactly one conjugation of to have for this subject type and tense");
                } else {
                    String haveConjugation = haveConjugations.get(0);
                    List<String> bePastParticiples = SpecialCaseVerbConjugations.TO_BE_VERB_CONJUGATION.getPastParticiples();
                    if (bePastParticiples.size() != 1) {
                        throw new UnsupportedOperationException("Must be exactly one past participle of to be for this subject type and tense");
                    } else {
                        return getPresentParticiples().stream().map(w -> SpecialCaseVerbConjugations.WILL_MODEL_VERB_CONJUGATION.conjugateVerb(subjectType, Tense.PRESENT_SIMPLE, true).get(0)  + " " + haveConjugation + " " + bePastParticiples.get(0) + " " + w).collect(Collectors.toList());
                    }
                }
            }
            return getPastParticiples();
        }else if (Tense.FUTURE_CONTINUOUS.equals(tense)){
            if (!verbOnly) {
                String beInfinitive = SpecialCaseVerbConjugations.TO_BE_VERB_CONJUGATION.getVerb();
                return getPresentParticiples().stream().map(w -> SpecialCaseVerbConjugations.WILL_MODEL_VERB_CONJUGATION.conjugateVerb(subjectType, Tense.PRESENT_SIMPLE, true).get(0)  + " " + beInfinitive + " " + w).collect(Collectors.toList());
            }
            return getPastParticiples();
        } else if (Tense.PAST_SIMPLE.equals(tense)){
            return getPastTenses(subjectType);
        } else if (Tense.PAST_PERFECT.equals(tense)){
            if (!verbOnly) {
                List<String> haveConjugations = SpecialCaseVerbConjugations.TO_HAVE_VERB_CONJUGATION.conjugateVerb(subjectType, tense, true);
                if (haveConjugations.size() != 1) {
                    throw new UnsupportedOperationException("Must be exactly one conjugation of to have for this subject type and tense");
                } else {
                    String haveConjugation = haveConjugations.get(0);
                    return getPastParticiples().stream().map(w -> haveConjugation + " " + w).collect(Collectors.toList());
                }
            }
            return getPastParticiples();
        } else if (Tense.PAST_PERFECT_CONTINUOUS.equals(tense)){
            if (!verbOnly) {
                List<String> haveConjugations = SpecialCaseVerbConjugations.TO_HAVE_VERB_CONJUGATION.conjugateVerb(subjectType, tense, true);
                if (haveConjugations.size() != 1) {
                    throw new UnsupportedOperationException("Must be exactly one conjugation of to have for this subject type and tense");
                } else {
                    List<String> bePastParticiples = SpecialCaseVerbConjugations.TO_BE_VERB_CONJUGATION.getPastParticiples();
                    if (bePastParticiples.size() != 1) {
                        throw new UnsupportedOperationException("Must be exactly one past participle of to be for this subject type and tense");
                    } else {
                        String haveConjugation = haveConjugations.get(0);
                        return getPresentParticiples().stream().map(w -> haveConjugation + " " + bePastParticiples.get(0) + " " + w).collect(Collectors.toList());
                    }
                }
            }
            return getPastParticiples();
        } else if (Tense.PAST_CONTINUOUS.equals(tense)){
            if (!verbOnly) {
                List<String> beConjugations = SpecialCaseVerbConjugations.TO_BE_VERB_CONJUGATION.conjugateVerb(subjectType, Tense.PAST_SIMPLE, true);
                if (beConjugations.size() != 1) {
                    throw new UnsupportedOperationException("Must be exactly one conjugation of to be for this subject type and tense");
                } else {
                    String beConjugation = beConjugations.get(0);
                    return getPresentParticiples().stream().map(w -> beConjugation + " " + w).collect(Collectors.toList());
                }
            }
            return getPastParticiples();
        }else {
            throw new UnsupportedOperationException("Not yet implemented");
        }
    }

}
