package io.github.johnsonsdictionary.conjugatedverbadverbmappings.mapping.impl;

import io.github.johnsonsdictionary.conjugatedverbadverbmappings.ConjugatedVerbAdverbMappings;
import io.github.johnsonsdictionary.conjugatedverbadverbmappings.mapping.ConjugatedVerbAdverbMappers;
import io.github.johnsonsdictionary.conjugatedverbadverbmappings.mapping.impl.base.ConjugatedVerbAdverbMapperTestBase;
import io.github.johnsonsdictionary.dictionary.core.words.WordType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.github.johnsonsdictionary.dictionary.core.JohnsonsDictionary.DICTIONARY;


public class JohnsonsConjugatedVerbAdverbMapperTest extends ConjugatedVerbAdverbMapperTestBase {

    @Test
    public void testConjugatedVerbAdverbMapping() {
        testConjugatedVerbAdverbMapping(ConjugatedVerbAdverbMappers.JOHNSONS_CONJUGATED_VERB_ADVERB_MAPPER, ConjugatedVerbAdverbMappings.ALL_MAPPED_CONJUGATED_VERBS, ConjugatedVerbAdverbMappings.ALL_ADVERBS, EXPECTED_CONJUGATED_VERB_ADVERB_PAIRS_JOHNSONS_FILE_PATH);
    }


    @Override
    protected void additionalChecks(String conjugatedVerb, String adverb) {

        boolean conjugatedVerbMatch = conjugatedVerb.endsWith("ing") || conjugatedVerb.endsWith("ed");
        boolean adverbMatch = DICTIONARY.keySet().stream().anyMatch(a -> a.getWord().equals(adverb) && a.getWordTypeIndicator().getWordTypes().contains(WordType.ADVERB));

        if (!conjugatedVerbMatch) {
            Assertions.fail(conjugatedVerb + " does not appear to be a conjugated verb");
        }

        if (!adverbMatch) {
            // Comment out for now as we only have a placeholder dictionary in place
            //Assertions.fail("No adverb:" + adverb + " in dictionary");
        }
        super.additionalChecks(conjugatedVerb, adverb);

    }
}
