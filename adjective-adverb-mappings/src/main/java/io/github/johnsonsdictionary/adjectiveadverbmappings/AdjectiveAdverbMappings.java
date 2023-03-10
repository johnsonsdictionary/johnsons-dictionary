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
package io.github.johnsonsdictionary.adjectiveadverbmappings;

import io.github.johnsonsdictionary.dictionary.core.util.WordDefinitionCSVReader;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinition;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinitionId;

import java.util.SortedMap;

/**
 * Statically defined variables to hold the loaded collections of adjectives, adverbs.
 *
 * @author Michael Lavelle
 */
public class AdjectiveAdverbMappings {

    private final static String JOHNSONS_ADJECTIVES_DEFINITION_FILE_PATH = "/adjective-adverb-mappings/adjectives/adjectives_johnsons.csv";

    public final static SortedMap<WordDefinitionId, WordDefinition> ALL_ADJECTIVES = new WordDefinitionCSVReader(false, JOHNSONS_ADJECTIVES_DEFINITION_FILE_PATH).load();

    private final static String JOHNSONS_ADVERBS_FILE_PATH = "/adjective-adverb-mappings/adverbs/adverbs_johnsons.csv";

    public final static SortedMap<WordDefinitionId, WordDefinition> ALL_ADVERBS = new WordDefinitionCSVReader(false, JOHNSONS_ADVERBS_FILE_PATH).load();


}
