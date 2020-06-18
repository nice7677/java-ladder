package ladder.domain.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorTest {

    @Test
    void RandomGeneratorTest() {
        boolean movable = RandomGenerator.isMovable();
        assertThat(movable).isNotNull();
    }
}