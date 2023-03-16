package io.github.johnsonsdictionary.dictionary.core;

import io.github.johnsonsdictionary.dictionary.core.util.JohnsonsDictionaryWordDefinitionCSVReader;
import io.github.johnsonsdictionary.dictionary.core.words.JohnsonsDictionaryWordDefinition;
import io.github.johnsonsdictionary.dictionary.core.words.JohnsonsDictionaryWordDefinitionId;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinition;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinitionId;
import io.github.johnsonsdictionary.omittedpreteritesandparticiples.OmittedPreteritesAndParticiples;

import java.util.*;
import java.util.stream.Collectors;

public class JohnsonsDictionary {

    public final static SortedMap<JohnsonsDictionaryWordDefinitionId, JohnsonsDictionaryWordDefinition> DICTIONARY = new JohnsonsDictionaryWordDefinitionCSVReader(false, "/dictionary.csv").load();

    public final static List<String> getDictionaryWords(boolean includeOmitted) {
        List<String> words = new ArrayList<>();
        words.addAll(DICTIONARY.keySet().stream().map(w -> w.getWord()).distinct().collect(Collectors.toList()));
        words.addAll(OmittedPreteritesAndParticiples.ALL_OMITTED_PRETERITES_AND_PARTICIPLES.keySet().stream().map(w -> w.getWord()).distinct().collect(Collectors.toList()));
        return words.stream().distinct().collect(Collectors.toList());
    }
}
