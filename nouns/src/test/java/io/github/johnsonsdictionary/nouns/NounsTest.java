package io.github.johnsonsdictionary.nouns;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NounsTest {

    @Test
    public void testNounsLoad() {
        Assertions.assertEquals(22037, Nouns.ALL_NOUNS.keySet().size());
    }
}
