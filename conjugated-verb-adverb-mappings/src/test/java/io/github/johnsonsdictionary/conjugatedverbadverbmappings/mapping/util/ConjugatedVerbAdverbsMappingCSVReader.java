package io.github.johnsonsdictionary.verbadverbmappings.mapping.util;


import io.github.johnsonsdictionary.conjugatedverbadverbmappings.mapping.util.ConjugatedVerbAdverbsMapping;
import io.github.johnsonsdictionary.dictionary.core.util.CSVReader;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinitionId;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.function.BiFunction;


public class ConjugatedVerbAdverbsMappingCSVReader extends CSVReader<WordDefinitionId, ConjugatedVerbAdverbsMapping> {

    public ConjugatedVerbAdverbsMappingCSVReader(BiFunction<WordDefinitionId, List<String>, ConjugatedVerbAdverbsMapping> mappingFunction, boolean firstLineAsHeader, String primaryFileResource, String... additionalFileResources) {
        super(mappingFunction,
                c -> WordDefinitionId.create(c.getConjugatedVerb(), c.getVerbMeaningId()),
                (r, v) -> WordDefinitionId.create(v.get(1), getAdverbMeaningId(r, v.get(1))),
                firstLineAsHeader, primaryFileResource, additionalFileResources);
    }

    public ConjugatedVerbAdverbsMappingCSVReader(BiFunction<WordDefinitionId, List<String>, ConjugatedVerbAdverbsMapping> mappingFunction, boolean firstLineAsHeader, List<String> fileResources) {
        super(mappingFunction,
                c -> WordDefinitionId.create(c.getConjugatedVerb(), c.getVerbMeaningId()),
                (r, v) -> WordDefinitionId.create(v.get(1), 1),
                firstLineAsHeader, fileResources);
    }

    private static int getAdverbMeaningId(SortedMap<WordDefinitionId, ConjugatedVerbAdverbsMapping> resultsSoFar, String adverb) {
        int meaningId = 1;
        for (Map.Entry<WordDefinitionId, ConjugatedVerbAdverbsMapping> entry : resultsSoFar.entrySet()) {
            if (entry.getValue().getAdverbs().contains(adverb)) {
                meaningId++;
            }
        }

        return meaningId;
    }
}
