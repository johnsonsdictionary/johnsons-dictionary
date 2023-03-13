package io.github.johnsonsdictionary.prepositions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrepositionsTest {

    @Test
    public void testPrepositionsLoad() {
        Assertions.assertEquals(32, Prepositions.ALL_PREPOSITIONS.keySet().size());
    }
}
