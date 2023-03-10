package io.github.johnsonsdictionary.adjectivesnotmappedtoadverbs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdjectivesNotMappedToAdverbsTest {

    @Test
    public void testAdverbLoad() {
        Assertions.assertEquals(7593, AdjectivesNotMappedToAdverbs.ALL_ADJECTIVES.keySet().size());
    }
}
