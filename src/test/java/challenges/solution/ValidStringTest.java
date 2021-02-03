package challenges.solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ValidStringTest {
    @ParameterizedTest
    @MethodSource("provideTestArguments")
    public void isMinimalWinStepsCountRight(String s, boolean isExpectedValid) {
        boolean isActualValid = ValidString.isValid(s);
        assertThat(isActualValid, is(isExpectedValid));
    }

    private static Stream<Arguments> provideTestArguments() {
        return Stream.of(
                Arguments.of("aabbcd", false), Arguments.of("aabbccddeefghi", false), Arguments.of("abcdefghhgfedecba", true)
        );
    }
}
