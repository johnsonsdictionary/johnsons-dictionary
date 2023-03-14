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
package io.github.johnsonsdictionary.omittedpreteritesandparticiples;

import io.github.johnsonsdictionary.dictionary.core.util.WordDefinitionCSVReader;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinition;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinitionId;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Statically defined variables to hold loaded collections preterites and participles referenced by their
 * corresponding verb entries, but which do not have an entry of their own.
 *
 * @author Michael Lavelle
 */
public class OmittedPreteritesAndParticiples {


    private final static String OMITTED_PRETERITES_AND_PARTICIPLES_FILE_PATH = "/omittedpreteritesandparticiples/omitted_preterites_and_participles.csv";

    public final static SortedMap<WordDefinitionId, WordDefinition> ALL_OMITTED_PRETERITES_AND_PARTICIPLES = new WordDefinitionCSVReader(false, OMITTED_PRETERITES_AND_PARTICIPLES_FILE_PATH).load();

    public final static SortedMap<WordDefinitionId, WordDefinition> ALL_WORDS = new TreeMap<>();

    static {
        ALL_WORDS.putAll(ALL_OMITTED_PRETERITES_AND_PARTICIPLES);
    }

}
