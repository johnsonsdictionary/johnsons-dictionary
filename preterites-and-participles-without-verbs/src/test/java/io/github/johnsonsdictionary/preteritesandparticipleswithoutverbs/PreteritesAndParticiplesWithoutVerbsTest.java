package io.github.johnsonsdictionary.preteritesandparticipleswithoutverbs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PreteritesAndParticiplesWithoutVerbsTest {

    @Test
    public void testPreteritesAndParticiplesWithoutVerbsLoad() {
        Assertions.assertEquals(30, PreteritesAndParticiplesWithoutVerbs.ALL_PRETERITES_AND_PARTICIPLES_WITHOUT_VERBS.keySet().size());
    }
}
