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
package io.github.johnsonsdictionary.verbs.conjugation.regular;

import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugation;
import io.github.johnsonsdictionary.verbs.conjugation.VerbConjugationBase;

import java.util.List;

/**
 * Default value object for the results of a regular Verb conjugation
 *
 * @author Michael Lavelle
 */
public class RegularVerbConjugation extends VerbConjugationBase implements VerbConjugation {

    public RegularVerbConjugation(String verb, int meaningId, String pastTense, String presentParticiple) {
        super(verb, meaningId, pastTense, presentParticiple);
    }

    public RegularVerbConjugation(String verb, int meaningId, List<String> pastTenses, List<String> presentParticiples) {
        super(verb, meaningId, pastTenses, presentParticiples);
    }

    @Override
    public String toString() {
        return "RegularVerbConjugation{" +
                "verb='" + verb + '\'' +
                ", pastTenses=" + pastTenses +
                ", presentParticiples=" + presentParticiples +
                '}';
    }

    @Override
    public boolean isModelVerb() {
        return false;
    }

    @Override
    public List<String> getPastParticiples() {
        return getPastTenses(null);
    }
}
