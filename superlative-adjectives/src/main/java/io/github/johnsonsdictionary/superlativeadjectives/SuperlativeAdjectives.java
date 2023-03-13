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
package io.github.johnsonsdictionary.pronouns;

import io.github.johnsonsdictionary.dictionary.core.util.WordDefinitionCSVReader;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinition;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinitionId;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Statically defined variables to hold loaded collections of superlative adjectives
 *
 * @author Michael Lavelle
 */
public class SuperlativeAdjectives {


    private final static String SUPERLATIVE_ADJECTIVES_FILE_PATH = "/superlative-adjectives/superlative_adjectives.csv";

    public final static SortedMap<WordDefinitionId, WordDefinition> ALL_SUPERLATIVE_ADJECTIVES = new WordDefinitionCSVReader(false, SUPERLATIVE_ADJECTIVES_FILE_PATH).load();

    public final static SortedMap<WordDefinitionId, WordDefinition> ALL_WORDS = new TreeMap<>();

    static {
        ALL_WORDS.putAll(ALL_SUPERLATIVE_ADJECTIVES);
    }

}
