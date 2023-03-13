package io.github.johnsonsdictionary.unclassifiedwords;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnclassifiedWordsTest {

    @Test
    public void testUnclassifiedWordsLoad() {
        Assertions.assertEquals(668, UnclassifiedWords.ALL_UNCLASSIFIED_WORDS.keySet().size());
    }
}
