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
package io.github.johnsonsdictionary.verbs;

import io.github.johnsonsdictionary.dictionary.core.util.WordDefinitionCSVReader;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinition;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinitionId;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Statically defined variables to hold the en-GB loaded collections of verbs, words etc in our vocab cache.
 *
 * @author Michael Lavelle
 */
public class EnglishWordsEnGB {

    private final static String JOHNSONS_REGULAR_VERBS_DEFINITION_FILE_PATH = "/english/regular/en-GB/johnsons_regular_verbs.csv";
    private final static String JOHNSONS_IRREGULAR_VERBS_TYPE_1_DEFINITION_FILE_PATH = "/english/irregular/en-GB/johnsons_irregular_verbs_type_1.csv";
    private final static String JOHNSONS_IRREGULAR_VERBS_TYPE_2_DEFINITION_FILE_PATH = "/english/irregular/en-GB/johnsons_irregular_verbs_type_2.csv";
    private final static String JOHNSONS_IRREGULAR_VERBS_TYPE_3_DEFINITION_FILE_PATH = "/english/irregular/en-GB/johnsons_irregular_verbs_type_3.csv";
    private final static String JOHNSONS_IRREGULAR_VERBS_TYPE_4_DEFINITION_FILE_PATH = "/english/irregular/en-GB/johnsons_irregular_verbs_type_4.csv";

    private final static String MISC_WORDS_FILE_PATH = "/english/regular/en-GB/misc_words.csv";

    public final static SortedMap<WordDefinitionId, WordDefinition> JOHNSONS_IRREGULAR_VERBS_TYPE_1 = new WordDefinitionCSVReader(false, JOHNSONS_IRREGULAR_VERBS_TYPE_1_DEFINITION_FILE_PATH).load();
    public final static SortedMap<WordDefinitionId, WordDefinition> JOHNSONS_IRREGULAR_VERBS_TYPE_2 = new WordDefinitionCSVReader(false, JOHNSONS_IRREGULAR_VERBS_TYPE_2_DEFINITION_FILE_PATH).load();
    public final static SortedMap<WordDefinitionId, WordDefinition> JOHNSONS_IRREGULAR_VERBS_TYPE_3 = new WordDefinitionCSVReader(false, JOHNSONS_IRREGULAR_VERBS_TYPE_3_DEFINITION_FILE_PATH).load();
    public final static SortedMap<WordDefinitionId, WordDefinition> JOHNSONS_IRREGULAR_VERBS_TYPE_4 = new WordDefinitionCSVReader(false, JOHNSONS_IRREGULAR_VERBS_TYPE_4_DEFINITION_FILE_PATH).load();

    public final static SortedMap<WordDefinitionId, WordDefinition> MISC_WORDS = new WordDefinitionCSVReader(false, MISC_WORDS_FILE_PATH).load();

    public final static SortedMap<WordDefinitionId, WordDefinition> JOHNSONS_REGULAR_VERBS = new WordDefinitionCSVReader(false, JOHNSONS_REGULAR_VERBS_DEFINITION_FILE_PATH).load();

    public final static SortedMap<WordDefinitionId, WordDefinition> JOHNSONS_IRREGULAR_VERBS = new WordDefinitionCSVReader(false, JOHNSONS_IRREGULAR_VERBS_TYPE_1_DEFINITION_FILE_PATH, JOHNSONS_IRREGULAR_VERBS_TYPE_2_DEFINITION_FILE_PATH, JOHNSONS_IRREGULAR_VERBS_TYPE_3_DEFINITION_FILE_PATH, JOHNSONS_IRREGULAR_VERBS_TYPE_4_DEFINITION_FILE_PATH).load();

    public final static SortedMap<WordDefinitionId, WordDefinition> ALL_REGULAR_VERBS = new WordDefinitionCSVReader(false,
            JOHNSONS_REGULAR_VERBS_DEFINITION_FILE_PATH
    ).load();


    public final static SortedMap<WordDefinitionId, WordDefinition> ALL_VERBS = new WordDefinitionCSVReader(false,
            JOHNSONS_REGULAR_VERBS_DEFINITION_FILE_PATH,
            JOHNSONS_IRREGULAR_VERBS_TYPE_1_DEFINITION_FILE_PATH,
            JOHNSONS_IRREGULAR_VERBS_TYPE_2_DEFINITION_FILE_PATH,
            JOHNSONS_IRREGULAR_VERBS_TYPE_3_DEFINITION_FILE_PATH,
            JOHNSONS_IRREGULAR_VERBS_TYPE_4_DEFINITION_FILE_PATH
    ).load();


    public final static SortedMap<WordDefinitionId, WordDefinition> ALL_IRREGULAR_VERBS = new WordDefinitionCSVReader(false,
            JOHNSONS_IRREGULAR_VERBS_TYPE_1_DEFINITION_FILE_PATH,
            JOHNSONS_IRREGULAR_VERBS_TYPE_2_DEFINITION_FILE_PATH,
            JOHNSONS_IRREGULAR_VERBS_TYPE_3_DEFINITION_FILE_PATH,
            JOHNSONS_IRREGULAR_VERBS_TYPE_4_DEFINITION_FILE_PATH
    ).load();


    public final static SortedMap<WordDefinitionId, WordDefinition> ALL_WORDS = new TreeMap<>();

    static {
        ALL_WORDS.putAll(ALL_VERBS);
        ALL_WORDS.putAll(MISC_WORDS);
    }

}
