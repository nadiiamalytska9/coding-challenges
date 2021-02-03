package challenges.solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MakingAnagramsTest {
    @ParameterizedTest
    @MethodSource("provideTestArguments")
    public void isDeleteCharactersNumberRight(String a, String b, int expectedDeletedCharactersNumber) {
        int actualDeletedCharactersNumber = MakingAnagrams.makeAnagram(a, b);
        assertThat(actualDeletedCharactersNumber, is(expectedDeletedCharactersNumber));
    }

    private static Stream<Arguments> provideTestArguments() {
        return Stream.of(
                Arguments.of("cde", "abc", 4),
                Arguments.of("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke", 30),
                Arguments.of("showman", "woman", 2)
        );
    }
}
