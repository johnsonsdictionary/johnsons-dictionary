package io.github.johnsonsdictionary.conjunctions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConjunctionsTest {

    @Test
    public void testConjunctionsLoad() {
        Assertions.assertEquals(13, Conjunctions.ALL_CONJUNCTIONS.keySet().size());
    }
}
