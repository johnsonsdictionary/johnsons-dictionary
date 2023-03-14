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

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Default base value object for the results of a Verb conjugation
 *
 * @author Michael Lavelle
 */
public abstract class VerbConjugationBase extends VerbConjugationBaseParent implements VerbConjugation {

    protected String verb;
    protected int meaningId;
    protected List<String> pastTenses;
    protected List<String> presentParticiples;

    public VerbConjugationBase(String verb, int meaningId, String pastTense, String presentParticiple) {
        this.verb = verb;
        this.meaningId = meaningId;
        if (meaningId < 1) {
            throw new IllegalArgumentException("Meaning id must be 1 or greater");
        }
        this.pastTenses = Arrays.asList(pastTense);
        this.presentParticiples = Arrays.asList(presentParticiple);
    }

    public VerbConjugationBase(String verb, int meaningId, List<String> pastTenses, List<String> presentParticiples) {
        this.verb = verb;
        this.meaningId = meaningId;
        if (meaningId < 1) {
            throw new IllegalArgumentException("Meaning id must be 1 or greater");
        }
        this.pastTenses = pastTenses;
        this.presentParticiples = presentParticiples;
    }

    public int getMeaningId() {
        return meaningId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VerbConjugationBase that = (VerbConjugationBase) o;
        return meaningId == that.meaningId &&
                Objects.equals(verb, that.verb) &&
                Objects.equals(pastTenses, that.pastTenses) &&
                Objects.equals(getPastParticiples(), that.getPastParticiples()) &&
                Objects.equals(presentParticiples, that.presentParticiples);
    }

    @Override
    public int hashCode() {
        return Objects.hash(verb, meaningId, pastTenses, getPastParticiples(), presentParticiples);
    }

    public String getVerb() {
        return verb;
    }

    public List<String> getPastTenses(SubjectType subjectType) {
        return pastTenses;
    }

    public List<String> getPresentParticiples() {
        return presentParticiples;
    }

    @Override
    public String getPresentTense(SubjectType subjectType) {
        return VerbConjugationLogic.getPresentTense(verb, subjectType);
    }

}
