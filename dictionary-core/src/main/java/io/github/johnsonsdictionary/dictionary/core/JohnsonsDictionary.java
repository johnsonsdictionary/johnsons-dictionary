package io.github.johnsonsdictionary.dictionary.core;

import io.github.johnsonsdictionary.dictionary.core.util.JohnsonsDictionaryWordDefinitionCSVReader;
import io.github.johnsonsdictionary.dictionary.core.words.JohnsonsDictionaryWordDefinition;
import io.github.johnsonsdictionary.dictionary.core.words.JohnsonsDictionaryWordDefinitionId;

import java.util.SortedMap;

public class JohnsonsDictionary {

    public final static SortedMap<JohnsonsDictionaryWordDefinitionId, JohnsonsDictionaryWordDefinition> DICTIONARY = new JohnsonsDictionaryWordDefinitionCSVReader(false, "/dictionary_placeholder.csv").load();

}
