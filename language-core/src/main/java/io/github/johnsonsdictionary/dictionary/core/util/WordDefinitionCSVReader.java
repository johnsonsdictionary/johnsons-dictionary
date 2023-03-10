package io.github.johnsonsdictionary.dictionary.core.util;

import io.github.johnsonsdictionary.dictionary.core.words.WordDefinition;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinitionId;

import java.util.List;

public class WordDefinitionCSVReader extends CSVReader<WordDefinitionId, WordDefinition> {

    public WordDefinitionCSVReader(boolean firstLineAsHeader, String primaryFileResource, String... additionalFileResources) {
        super((i, v) -> createWordDefinition(i.getMeaningId(), v),
                c -> c.getWordDefinitionId(),
                (r, v) -> new WordDefinitionId(v.get(0), getOccurrenceId(r, v.get(0))),
                firstLineAsHeader, primaryFileResource, additionalFileResources);
    }

    public WordDefinitionCSVReader(boolean firstLineAsHeader, List<String> fileResources) {
        super((i, v) -> createWordDefinition(i.getMeaningId(), v),
                c -> c.getWordDefinitionId(),
                (r, v) -> new WordDefinitionId(v.get(0), getOccurrenceId(r, v.get(0))),
                firstLineAsHeader, fileResources);
    }

    private static WordDefinition createWordDefinition(int meaningId, List<String> values) {
        if (values.size() > 1) {
            return new WordDefinition(new WordDefinitionId(values.get(0), meaningId), Boolean.valueOf(values.get(1)), values.subList(2, values.size()));
        } else {
            return new WordDefinition(new WordDefinitionId(values.get(0), meaningId));
        }
    }
}
