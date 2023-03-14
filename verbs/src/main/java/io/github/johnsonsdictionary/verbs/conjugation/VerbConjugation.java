/*
 * Copyright 2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package io.github.johnsonsdictionary.verbs.conjugation;

import io.github.johnsonsdictionary.verbs.conjugation.subjects.SubjectType;
import io.github.johnsonsdictionary.verbs.tenses.Tense;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Interface for the results of a Verb conjugation - just a tagging interface at present
 *
 * @author Michael Lavelle
 */
public interface VerbConjugation {
    String getVerb();

    boolean isModelVerb();

    default boolean isSubjectSuffixed() {
        return false;
    }

    default List<SubjectType> getSupportedSubjectTypes() {
        List<SubjectType> subjectTypes = new ArrayList<>();
        subjectTypes.addAll(Arrays.stream(SubjectType.values()).collect(Collectors.toList()));
        subjectTypes.remove(SubjectType.NONE);
        return subjectTypes;
    }

    default List<Tense> getSupportedTenses() {
        if (isModelVerb()) {
            return Arrays.asList(Tense.PRESENT_SIMPLE, Tense.PAST_SIMPLE);
        } else {
            return Arrays.stream(Tense.values()).collect(Collectors.toList());
        }
    }

    int getMeaningId();

    List<String> getPastTenses(SubjectType thirdPersonSingular);

    List<String> getPastParticiples();

    List<String> getPresentParticiples();

    default boolean hasPresentParticiples() {
        return true;
    }

    default boolean hasPastParticiples() {
        return true;
    }

    String getPresentTense(SubjectType thirdPersonSingular);

    List<String> conjugateVerb(SubjectType subjectType, Tense tense, boolean verbOnly);

    List<String> conjugateVerb(String subjectName, SubjectType subjectType, Tense tense);


}
