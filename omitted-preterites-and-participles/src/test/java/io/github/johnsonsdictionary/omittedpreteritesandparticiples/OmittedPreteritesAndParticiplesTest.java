package io.github.johnsonsdictionary.omittedpreteritesandparticiples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OmittedPreteritesAndParticiplesTest {

    @Test
    public void testOmittedPreteritesAndParticiplesLoad() {
        Assertions.assertEquals(83, OmittedPreteritesAndParticiples.ALL_OMITTED_PRETERITES_AND_PARTICIPLES.keySet().size());
    }
}
