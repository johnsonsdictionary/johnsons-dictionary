package io.github.johnsonsdictionary.particles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParticlesTest {

    @Test
    public void testParticlesLoad() {
        Assertions.assertEquals(4, Particles.ALL_PARTICLES.keySet().size());
    }
}
