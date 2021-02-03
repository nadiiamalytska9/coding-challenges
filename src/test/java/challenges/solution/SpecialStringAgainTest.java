package challenges.solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SpecialStringAgainTest {
    @ParameterizedTest
    @MethodSource("provideTestArguments")
    public void isMinimalWinStepsCountRight(String string, long expectedTotalSpecialSubstringsCount) {
        long actualTotalSpecialSubstringsCount = SpecialStringAgain.substrCount(string.length(), string);
        assertThat(actualTotalSpecialSubstringsCount, is(expectedTotalSpecialSubstringsCount));
    }

    private static Stream<Arguments> provideTestArguments() {
        return Stream.of(
                Arguments.of("asasd", 7L),
                Arguments.of("abcbaba", 10L),
                Arguments.of("aaaa", 10L)
        );
    }
}
