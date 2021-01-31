package challenges.solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RepeatedStringTest {
    @ParameterizedTest
    @MethodSource("provideTestArguments")
    public void isMinimalWinStepsCountRight(String string, long n, long expectedRepeatedStringsCount) {
        long actualRepeatedStringsCount = RepeatedString.repeatedString(string, n);
        assertThat("Expected repeated string count: [" + expectedRepeatedStringsCount + "]. But received wrong value: [" + actualRepeatedStringsCount + "]",
                actualRepeatedStringsCount, is(expectedRepeatedStringsCount));
    }

    private static Stream<Arguments> provideTestArguments() {
        return Stream.of(
                Arguments.of("aba", 10L, 7L),
                Arguments.of("a", 1000000000000L, 1000000000000L),
                Arguments.of("ababa", 3L, 2L),
                Arguments.of("beeaabc", 711560125001L, 203302892858L)
        );
    }
}
