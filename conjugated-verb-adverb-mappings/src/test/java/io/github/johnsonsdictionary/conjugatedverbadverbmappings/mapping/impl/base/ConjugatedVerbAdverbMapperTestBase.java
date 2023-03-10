package io.github.johnsonsdictionary.conjugatedverbadverbmappings.mapping.impl.base;

import io.github.johnsonsdictionary.conjugatedverbadverbmappings.mapping.ConjugatedVerbAdverbMappers;
import io.github.johnsonsdictionary.conjugatedverbadverbmappings.mapping.util.ConjugatedVerbAdverbsMapping;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinition;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinitionId;
import io.github.johnsonsdictionary.verbadverbmappings.mapping.ConjugatedVerbAdverbMapper;
import io.github.johnsonsdictionary.verbadverbmappings.mapping.util.ConjugatedVerbAdverbsMappingCSVReader;
import org.junit.jupiter.api.Assertions;

import java.util.*;
import java.util.stream.Collectors;

public class ConjugatedVerbAdverbMapperTestBase {


    protected final static String EXPECTED_CONJUGATED_VERB_ADVERB_PAIRS_JOHNSONS_FILE_PATH = "/conjugated-verb-adverb-mappings/conjugated_verb_adverb_mappings_johnsons.csv";


    protected void testConjugatedVerbAdverbMapping(SortedMap<WordDefinitionId, WordDefinition> adjectivesStartingWithA, SortedMap<WordDefinitionId, WordDefinition> adverbsStartingWithA, String expectedResultsFilePath) {
        testConjugatedVerbAdverbMapping(ConjugatedVerbAdverbMappers.JOHNSONS_CONJUGATED_VERB_ADVERB_MAPPER, adjectivesStartingWithA, adverbsStartingWithA, expectedResultsFilePath);
    }


    protected void testConjugatedVerbAdverbMapping(ConjugatedVerbAdverbMapper adverbMapper, SortedMap<WordDefinitionId, WordDefinition> verbsMap, SortedMap<WordDefinitionId, WordDefinition> adverbsMap, String expectedResultsFilePath) {

        List<String> verbs = new ArrayList<>();
        for (WordDefinitionId a : verbsMap.keySet()) {
            verbs.add(a.getWord());
        }
        List<String> adverbs = new ArrayList<>();
        for (WordDefinitionId adverb : adverbsMap.keySet()) {
            adverbs.add(adverb.getWord());
        }
        int verbsSize = verbs.size();
        //Assertions.assertEquals(adjectivesSize, adverbs.size());
        verbs = verbs.stream().distinct().collect(Collectors.toList());
        adverbs = adverbs.stream().distinct().collect(Collectors.toList());

        int distinctVerbsSize = verbs.size();
        int distinctAdverbsSize = adverbs.size();
        Assertions.assertEquals(verbsSize, distinctVerbsSize, "Distinct verbs list size is different from verbs list size");
        // Cannot check for equality here, as there are some adjectives (eg. analytic, analytical which map to the same adverb - analytically)
        Assertions.assertTrue(distinctVerbsSize >= distinctAdverbsSize, "Distinct verbs size is less than distinct adverbs size");

        SortedMap<WordDefinitionId, ConjugatedVerbAdverbsMapping> expectedMappings =
                new ConjugatedVerbAdverbsMappingCSVReader((i, v) ->
                        new ConjugatedVerbAdverbsMapping(v.get(0), i.getMeaningId(), v.subList(1, v.size())),
                        false, Arrays.asList(expectedResultsFilePath)).load();

        Assertions.assertEquals(distinctVerbsSize, expectedMappings.size(), "Size of expected mappings doesn't match verbs size");
        for (Map.Entry<WordDefinitionId, ConjugatedVerbAdverbsMapping> entry : expectedMappings.entrySet()) {
            Assertions.assertEquals(entry.getKey().getWord(), entry.getValue().getConjugatedVerb());
            Assertions.assertTrue(verbs.contains(entry.getValue().getConjugatedVerb()), "Registered verbs list doesn't contain expected verb of:" + entry.getValue().getConjugatedVerb());
            Assertions.assertTrue(adverbs.containsAll(entry.getValue().getAdverbs()), "Registered adverb list doesn't contain all expected adverbs of:" + entry.getValue().getAdverbs());
            List<String> mappedAdverbs = adverbMapper.getAdverbsFromConjugatedVerb(entry.getKey().getWord());
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
