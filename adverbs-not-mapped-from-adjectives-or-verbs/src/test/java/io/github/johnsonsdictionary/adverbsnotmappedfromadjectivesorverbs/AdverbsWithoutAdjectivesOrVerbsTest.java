package io.github.johnsonsdictionary.adverbsnotmappedfromadjectivesorverbs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdverbsWithoutAdjectivesOrVerbsTest {

    @Test
    public void testAdverbLoad() {
        Assertions.assertEquals(816, AdverbsWithoutAdjectivesOrVerbs.ALL_ADVERBS.keySet().size());
    }
}
