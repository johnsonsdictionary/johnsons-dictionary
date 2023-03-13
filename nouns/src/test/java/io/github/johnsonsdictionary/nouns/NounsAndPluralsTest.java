package io.github.johnsonsdictionary.nouns;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NounsAndPluralsTest {

    @Test
    public void testNounsAndPluralsLoad() {
        Assertions.assertEquals(22043, Nouns.ALL_WORDS.keySet().size());
    }
}
