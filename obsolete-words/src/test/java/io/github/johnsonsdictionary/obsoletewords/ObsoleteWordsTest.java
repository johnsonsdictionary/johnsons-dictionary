package io.github.johnsonsdictionary.obsoletewords;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ObsoleteWordsTest {

    @Test
    public void testObsoleteWordsLoad() {
        Assertions.assertEquals(4, ObsoleteWords.ALL_OBSOLETE_WORDS.keySet().size());
    }
}
