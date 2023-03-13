package io.github.johnsonsdictionary.nouns;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PluralsTest {

    @Test
    public void testPluralsLoad() {
        Assertions.assertEquals(6, Nouns.ALL_PLURALS.keySet().size());
    }
}
