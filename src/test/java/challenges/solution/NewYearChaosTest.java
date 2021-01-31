package challenges.solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NewYearChaosTest {
    @ParameterizedTest
    @MethodSource("provideTestArguments")
    public void isMinimalWinStepsCountRight(int[] arr, int expectedBribesAmount) {
        int actualBribesAmount = NewYearChaos.minimumBribes(arr);
        assertThat("Expected bribes amount: [" + expectedBribesAmount + "]. But received wrong value: [" + actualBribesAmount + "]",
                actualBribesAmount, is(expectedBribesAmount));
    }

    private static Stream<Arguments> provideTestArguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 5, 3, 4, 7, 8, 6}, 4),
                Arguments.of(new int[]{1, 2, 5, 3, 7, 8, 6, 4}, 7),
                Arguments.of(new int[]{2, 1, 5, 3, 4}, 3)
        );
    }
}
