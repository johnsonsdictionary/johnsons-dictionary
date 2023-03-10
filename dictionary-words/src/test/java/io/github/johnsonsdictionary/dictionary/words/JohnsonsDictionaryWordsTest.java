package io.github.johnsonsdictionary.dictionary.words;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JohnsonsDictionaryWordsTest {

    @Test
    public void testDictionaryLoad() {
        Assertions.assertEquals(2610, JohnsonsDictionaryWords.getAdverbs().size());
    }
}
