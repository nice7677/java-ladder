package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    @Test
    void createLinesUpToHeight() {
        Lines lines = new Lines(2, 3);
        List<Line> expected = Arrays.asList(
                new Line(2),
                new Line(2),
                new Line(2)
        );
        assertThat(lines.lines()
                .stream()
                .map(line -> line.points().size()).collect(Collectors.toList())
        ).isEqualTo(expected.stream()
                .map(line -> line.points().size()).collect(Collectors.toList())
        );
    }
}