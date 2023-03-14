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
package io.github.johnsonsdictionary.preteritesandparticipleswithoutverbs;

import io.github.johnsonsdictionary.dictionary.core.util.WordDefinitionCSVReader;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinition;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinitionId;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Statically defined variables to hold loaded collections of preterites and participles
 *
 * @author Michael Lavelle
 */
public class PreteritesAndParticiplesWithoutVerbs {


    private final static String PRETERITES_AND_PARTICIPLES_WITHOUT_VERBS_FILE_PATH = "/preterites-and-participles-without-verbs/preterites_and_participles_without_verbs.csv";

    public final static SortedMap<WordDefinitionId, WordDefinition> ALL_PRETERITES_AND_PARTICIPLES_WITHOUT_VERBS = new WordDefinitionCSVReader(false, PRETERITES_AND_PARTICIPLES_WITHOUT_VERBS_FILE_PATH).load();

    public final static SortedMap<WordDefinitionId, WordDefinition> ALL_WORDS = new TreeMap<>();

    static {
        ALL_WORDS.putAll(ALL_PRETERITES_AND_PARTICIPLES_WITHOUT_VERBS);
    }

}
