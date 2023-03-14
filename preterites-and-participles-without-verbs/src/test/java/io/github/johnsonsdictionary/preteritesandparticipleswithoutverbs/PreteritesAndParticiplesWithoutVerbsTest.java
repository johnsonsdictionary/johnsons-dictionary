package io.github.johnsonsdictionary.preteritesandparticipleswithoutverbs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PreteritesAndParticiplesWithoutVerbsTest {

    @Test
    public void testParticiplesWithoutVerbsLoad() {
        Assertions.assertEquals(30, PretoritesAndParticiplesWithoutVerbs.ALL_PRETERITES_AND_PARTICIPLES_WITHOUT_VERBS.keySet().size());
    }
}
