package challenges.solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CommonChildTest {
    @ParameterizedTest
    @MethodSource("provideTestArguments")
    public void isMinimalWinStepsCountRight(String s1, String s2, int expectedChildMaxLength) {
        int actualChildMaxLength = CommonChild.commonChild(s1, s2);
        assertThat("Expected child max length: [" + expectedChildMaxLength + "]. But received wrong value: [" + actualChildMaxLength + "]",
                actualChildMaxLength, is(expectedChildMaxLength));
    }

    private static Stream<Arguments> provideTestArguments() {
        return Stream.of(
                Arguments.of("HARRY", "SALLY", 2), Arguments.of("AA", "BB", 0), Arguments.of("SHINCHAN", "NOHARAAA", 3)
        );
    }
}
