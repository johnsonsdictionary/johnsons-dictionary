package io.github.johnsonsdictionary.adjectiveadverbmappings.mapping.impl;

import io.github.johnsonsdictionary.adjectiveadverbmappings.mapping.AdjectiveAdverbMappers;
import io.github.johnsonsdictionary.adjectiveadverbmappings.AdjectiveAdverbMappings;
import io.github.johnsonsdictionary.adjectiveadverbmappings.mapping.impl.base.AdjectiveAdverbMapperTestBase;
import io.github.johnsonsdictionary.dictionary.core.util.JohnsonsDictionaryWordDefinitionCSVReader;
import io.github.johnsonsdictionary.dictionary.core.words.JohnsonsDictionaryWordDefinition;
import io.github.johnsonsdictionary.dictionary.core.words.JohnsonsDictionaryWordDefinitionId;
import io.github.johnsonsdictionary.dictionary.core.words.WordType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.SortedMap;


public class JohnsonsAdjectiveAdverbMapperTest extends AdjectiveAdverbMapperTestBase {

    public static SortedMap<JohnsonsDictionaryWordDefinitionId, JohnsonsDictionaryWordDefinition> DICTIONARY = new JohnsonsDictionaryWordDefinitionCSVReader(false, "/dictionary_placeholder.csv").load();

    @Test
    public void testAdjectiveAdverbMapping() {
        testAdjectiveAdverbMapping(AdjectiveAdverbMappers.JOHNSONS_ADJECTIVE_ADVERB_MAPPER, AdjectiveAdverbMappings.ALL_ADJECTIVES, AdjectiveAdverbMappings.ALL_ADVERBS, EXPECTED_ADJECTIVE_ADVERB_PAIRS_JOHNSONS_FILE_PATH);
    }

    @Override
    protected void additionalChecks(String adjective, String adverb) {

        boolean adjectiveMatch = DICTIONARY.keySet().stream().anyMatch(a -> a.getWord().equals(adjective) && a.getWordTypeIndicator().getWordTypes().contains(WordType.ADJECTIVE));
        boolean adverbMatch = DICTIONARY.keySet().stream().anyMatch(a -> a.getWord().equals(adverb) && a.getWordTypeIndicator().getWordTypes().contains(WordType.ADVERB));

        if (!adjectiveMatch) {
            // Comment out for now, as we only have a placeholder dictionary in place
            //Assertions.fail("No adjective:" + adjective + " in dictionary");
        }

        if (!adverbMatch) {
            // Comment out for now, as we only have a placeholder dictionary in place
            //Assertions.fail("No adverb:" + adverb + " in dictionary");
        }
        super.additionalChecks(adjective, adverb);

    }
}
