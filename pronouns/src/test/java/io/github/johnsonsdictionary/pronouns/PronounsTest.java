package io.github.johnsonsdictionary.pronouns;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PronounsTest {

    @Test
    public void testPronounsLoad() {
        Assertions.assertEquals(38, Pronouns.ALL_PRONOUNS.keySet().size());
    }
}
