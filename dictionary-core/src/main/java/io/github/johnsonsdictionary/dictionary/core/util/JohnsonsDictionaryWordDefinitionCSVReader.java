package io.github.johnsonsdictionary.dictionary.core.util;


import io.github.johnsonsdictionary.dictionary.core.words.*;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public class JohnsonsDictionaryWordDefinitionCSVReader extends CSVReader<JohnsonsDictionaryWordDefinitionId, JohnsonsDictionaryWordDefinition> {

    public JohnsonsDictionaryWordDefinitionCSVReader(boolean firstLineAsHeader, String primaryFileResource, String... additionalFileResources) {
        super((i, v) -> createWordDefinition(i.getMeaningId(), i.getWordTypeIndicator(), v),
                c -> c.getWordDefinitionId(),
                (r, v) -> JohnsonsDictionaryWordDefinitionId.create(getWord(v.get(1)), WordTypeIndicator.valueOf(v.get(0)), getLocalOccurrenceId(r, getWord(v.get(1)), WordTypeIndicator.valueOf(v.get(0)))),
                firstLineAsHeader, primaryFileResource, additionalFileResources);
    }

    protected static int getLocalOccurrenceId(SortedMap<JohnsonsDictionaryWordDefinitionId, JohnsonsDictionaryWordDefinition> resultsSoFar, String verb, WordTypeIndicator typeIndicator) {
        int meaningId = 1;
        for (Map.Entry<JohnsonsDictionaryWordDefinitionId, JohnsonsDictionaryWordDefinition> entry : resultsSoFar.entrySet()) {
            if (entry.getValue().getWord().equals(verb) && entry.getValue().getWordDefinitionId().getWordTypeIndicator().equals(typeIndicator)) {
                meaningId++;
            }
        }
        return meaningId;
    }

    public JohnsonsDictionaryWordDefinitionCSVReader(boolean firstLineAsHeader, List<String> fileResources) {
        super((i, v) -> createWordDefinition(i.getMeaningId(), i.getWordTypeIndicator(), v),
                c -> c.getWordDefinitionId(),
                (r, v) -> JohnsonsDictionaryWordDefinitionId.create(getWord(v.get(1)), WordTypeIndicator.valueOf(v.get(0)), getLocalOccurrenceId(r, getWord(v.get(1)), WordTypeIndicator.valueOf(v.get(0)))),
                firstLineAsHeader, fileResources);
    }

    private static String getWord(String w) {
        return w.replaceAll("\\?", ",");
    }

    private static JohnsonsDictionaryWordDefinition createWordDefinition(int meaningId, WordTypeIndicator wordTypeIndicator, List<String> values) {
        if (values.size() > 2) {
            return new JohnsonsDictionaryWordDefinition(JohnsonsDictionaryWordDefinitionId.create(values.get(1), wordTypeIndicator, meaningId), Boolean.valueOf(values.get(2)), values.subList(3, values.size()));
        } else {
            return new JohnsonsDictionaryWordDefinition(JohnsonsDictionaryWordDefinitionId.create(values.get(1), wordTypeIndicator, meaningId));
        }
    }
}
