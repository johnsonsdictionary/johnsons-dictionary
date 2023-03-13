package io.github.johnsonsdictionary.superlativeadjectives;

import io.github.johnsonsdictionary.pronouns.SuperlativeAdjectives;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SuperlativeAdjectivesTest {

    @Test
    public void testSuperlativeAdjectivesLoad() {
        Assertions.assertEquals(2, SuperlativeAdjectives.ALL_SUPERLATIVE_ADJECTIVES.keySet().size());
    }
}
