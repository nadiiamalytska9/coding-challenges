package challenges.solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AlternatingCharactersTest {
    @ParameterizedTest
    @MethodSource("provideTestArguments")
    public void isDeletedAllAlternatingCharacters(String string, int expectedDeletedAlternatingCharacters) {
        int actualDeletedAlternatingCharacters = AlternatingCharacters.alternatingCharacters(string);
        assertThat(actualDeletedAlternatingCharacters, is(expectedDeletedAlternatingCharacters));
    }

    private static Stream<Arguments> provideTestArguments() {
        return Stream.of(
                Arguments.of("AAAA", 3), Arguments.of("BBBBB", 4), Arguments.of("ABABABAB", 0),
                Arguments.of("BABABA", 0), Arguments.of("AAABBB", 4), Arguments.of("AAABBBAABB", 6),
                Arguments.of("ABABABAA", 1), Arguments.of("AAABBBAABB", 6), Arguments.of("AABBAABBB", 5)
        );
    }
}
