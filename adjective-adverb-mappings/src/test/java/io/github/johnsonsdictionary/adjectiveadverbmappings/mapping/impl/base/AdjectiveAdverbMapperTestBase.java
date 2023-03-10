package io.github.johnsonsdictionary.adjectiveadverbmappings.mapping.impl.base;

import io.github.johnsonsdictionary.adjectiveadverbmappings.mapping.AdjectiveAdverbMapper;
import io.github.johnsonsdictionary.adjectiveadverbmappings.mapping.AdjectiveAdverbMappers;
import io.github.johnsonsdictionary.adjectiveadverbmappings.mapping.util.AdjectiveAdverbsMapping;
import io.github.johnsonsdictionary.adjectiveadverbmappings.mapping.util.AdjectiveAdverbsMappingCSVReader;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinition;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinitionId;
import org.junit.jupiter.api.Assertions;

import java.util.*;
import java.util.stream.Collectors;

public class AdjectiveAdverbMapperTestBase {

    protected final static String EXPECTED_ADJECTIVE_ADVERB_PAIRS_JOHNSONS_FILE_PATH = "/adjective-adverb-mappings/adjective_adverb_mappings_johnsons.csv";


    protected void testAdjectiveAdverbMapping(SortedMap<WordDefinitionId, WordDefinition> adjectivesStartingWithA, SortedMap<WordDefinitionId, WordDefinition> adverbsStartingWithA, String expectedResultsFilePath) {
        testAdjectiveAdverbMapping(AdjectiveAdverbMappers.JOHNSONS_ADJECTIVE_ADVERB_MAPPER, adjectivesStartingWithA, adverbsStartingWithA, expectedResultsFilePath);
    }


    protected void testAdjectiveAdverbMapping(AdjectiveAdverbMapper adverbMapper, SortedMap<WordDefinitionId, WordDefinition> adjectivesMap, SortedMap<WordDefinitionId, WordDefinition> adverbsMap, String expectedResultsFilePath) {

        List<String> adjectives = new ArrayList<>();
        for (WordDefinitionId a : adjectivesMap.keySet()) {
            adjectives.add(a.getWord());
        }
        List<String> adverbs = new ArrayList<>();
        for (WordDefinitionId a : adverbsMap.keySet()) {
            adverbs.add(a.getWord());
        }
        int adjectivesSize = adjectives.size();
        //Assertions.assertEquals(adjectivesSize, adverbs.size());
        adjectives = adjectives.stream().distinct().collect(Collectors.toList());
        adverbs = adverbs.stream().distinct().collect(Collectors.toList());

        int distinctAdjectivesSize = adjectives.size();
        System.out.println("Distinct adjectives size:" + distinctAdjectivesSize);

        int distinctAdverbsSize = adverbs.size();
        Assertions.assertEquals(adjectivesSize, distinctAdjectivesSize, "Distinct adjectives list size is different from adjectives list size");
        // Cannot check for equality here, as there are some adjectives (eg. analytic, analytical which map to the same adverb - analytically)
        Assertions.assertTrue(distinctAdjectivesSize >= adverbs.size(), "Distinct adjectives size is less than  distinct adverbs size");

        SortedMap<WordDefinitionId, AdjectiveAdverbsMapping> expectedMappings =
                new AdjectiveAdverbsMappingCSVReader((i, v) ->
                        new AdjectiveAdverbsMapping(v.get(0), i.getMeaningId(), v.subList(1, v.size())),
                        false, Arrays.asList(expectedResultsFilePath)).load();

        Assertions.assertEquals(adjectivesSize, expectedMappings.size(), "Size of expected mappings doesn't match adjectives size");
        for (Map.Entry<WordDefinitionId, AdjectiveAdverbsMapping> entry : expectedMappings.entrySet()) {
            Assertions.assertEquals(entry.getKey().getWord(), entry.getValue().getAdjective());
            Assertions.assertTrue(adjectives.contains(entry.getValue().getAdjective()), "Registered adjective list doesn't contain expected adjective of:" + entry.getValue().getAdjective());
            Assertions.assertTrue(adverbs.containsAll(entry.getValue().getAdverbs()), "Registered adverb list doesn't contain all expected adverbs of:" + entry.getValue().getAdverbs());
            List<String> mappedAdverbs = adverbMapper.getAdverbsFromAdjective(entry.getKey().getWord());
            int index = 0;
            for (String adv : entry.getValue().getAdverbs()) {
                additionalChecks(entry.getKey().getWord(), adv);
                if (index >= mappedAdverbs.size()) {
                    Assertions.fail("Expecting " + entry.getValue().getAdverbs().size() + " adverbs to be mapped by mapper for '" + entry.getKey().getWord() + "', but found only " + index);
                } else {
                    additionalChecks(entry.getKey().getWord(), mappedAdverbs.get(index));
                }
                index++;

            }
            Assertions.assertEquals(entry.getValue().getAdverbs(), mappedAdverbs, "Mapped adverbs doesn't match expected adverbs of:" + entry.getValue().getAdverbs());
        }
    }

    protected void additionalChecks(String adjective, String adverb) {

    }
}
