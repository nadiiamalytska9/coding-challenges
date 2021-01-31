package challenges.solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SpecialStringAgainTest {
    @ParameterizedTest
    @MethodSource("provideTestArguments")
    public void isMinimalWinStepsCountRight(String string, long expectedTotalSpecialSubstringsCount) {
        long actualTotalSpecialSubstringsCount = SpecialStringAgain.substrCount(string.length(), string);
        assertThat("Expected total special substrings count: [" + expectedTotalSpecialSubstringsCount + "]. But received wrong value: [" + actualTotalSpecialSubstringsCount + "]",
                actualTotalSpecialSubstringsCount, is(expectedTotalSpecialSubstringsCount));
    }

    private static Stream<Arguments> provideTestArguments() {
        return Stream.of(
                Arguments.of("asasd", 7L),
                Arguments.of("abcbaba", 10L),
                Arguments.of("aaaa", 10L)
        );
    }
}
