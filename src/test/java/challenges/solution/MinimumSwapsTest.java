package challenges.solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MinimumSwapsTest {
    @ParameterizedTest
    @MethodSource("provideTestArguments")
    public void isSwapCountMinimum(int[] arr, int expectedMinimumSwaps) {
        int actualMinimumSwaps = MinimumSwaps.minimumSwaps(arr);
        assertThat("Expected minimum swaps count: [" + expectedMinimumSwaps + "]. But received wrong value: [" + actualMinimumSwaps + "]",
                actualMinimumSwaps, is(expectedMinimumSwaps));
    }

    private static Stream<Arguments> provideTestArguments() {
        return Stream.of(
                Arguments.of(new int[]{4, 3, 1, 2}, 3),
                Arguments.of(new int[]{2, 3, 4, 1, 5}, 3),
                Arguments.of(new int[]{1, 3, 5, 2, 4, 6, 7}, 3),
                Arguments.of(new int[]{3, 7, 6, 9, 1, 8, 10, 4, 2, 5}, 9)
        );
    }
}
