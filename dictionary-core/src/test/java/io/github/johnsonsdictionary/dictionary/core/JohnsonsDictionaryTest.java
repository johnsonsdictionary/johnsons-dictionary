package io.github.johnsonsdictionary.dictionary.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JohnsonsDictionaryTest {

    @Test
    public void testDictionaryLoad() {
        Assertions.assertEquals(1, JohnsonsDictionary.DICTIONARY.size());
    }
}
