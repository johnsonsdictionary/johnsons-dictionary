package io.github.johnsonsdictionary.adjectiveadverbmappings.mapping.util;


import io.github.johnsonsdictionary.dictionary.core.util.CSVReader;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinitionId;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.function.BiFunction;


public class AdjectiveAdverbsMappingCSVReader extends CSVReader<WordDefinitionId, AdjectiveAdverbsMapping> {

    public AdjectiveAdverbsMappingCSVReader(BiFunction<WordDefinitionId, List<String>, AdjectiveAdverbsMapping> mappingFunction, boolean firstLineAsHeader, String primaryFileResource, String... additionalFileResources) {
        super(mappingFunction,
                c -> WordDefinitionId.create(c.getAdjective(), c.getAdjectiveMeaningId()),
                (r, v) -> WordDefinitionId.create(v.get(1), getAdverbMeaningId(r, v.get(1))),
                firstLineAsHeader, primaryFileResource, additionalFileResources);
    }

    public AdjectiveAdverbsMappingCSVReader(BiFunction<WordDefinitionId, List<String>, AdjectiveAdverbsMapping> mappingFunction, boolean firstLineAsHeader, List<String> fileResources) {
        super(mappingFunction,
                c -> WordDefinitionId.create(c.getAdjective(), c.getAdjectiveMeaningId()),
                (r, v) -> WordDefinitionId.create(v.get(1), 1),
                firstLineAsHeader, fileResources);
    }

    private static int getAdverbMeaningId(SortedMap<WordDefinitionId, AdjectiveAdverbsMapping> resultsSoFar, String adverb) {
        int meaningId = 1;
        for (Map.Entry<WordDefinitionId, AdjectiveAdverbsMapping> entry : resultsSoFar.entrySet()) {
            if (entry.getValue().getAdverbs().contains(adverb)) {
                meaningId++;
            }
        }

        return meaningId;
    }
}
