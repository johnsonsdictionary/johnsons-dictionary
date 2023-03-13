package io.github.johnsonsdictionary.interjections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InterjectionsTest {

    @Test
    public void testInterjectionLoad() {
        Assertions.assertEquals(75, Interjections.ALL_INTERJECTIONS.keySet().size());
    }
}
