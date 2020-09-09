import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import solutions.JumpingCloud;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class JumpingCloudTest {
    @ParameterizedTest
    @MethodSource("provideTestArguments")
    public void isMinimalWinStepsCountRight(int cloudsCount, int[] clouds, int expectedMinimalWinStepsCount) {
        int actualPairsNumber = JumpingCloud.jumpingOnClouds(cloudsCount, clouds);
        assertThat("Expected minimal win steps count: [" + expectedMinimalWinStepsCount + "]. But received wrong value: [" + actualPairsNumber + "]",
                expectedMinimalWinStepsCount, is(actualPairsNumber));
    }

    private static Stream<Arguments> provideTestArguments() {
        return Stream.of(
                Arguments.of(7, new int[]{0, 0, 1, 0, 0, 1, 0}, 4),
                Arguments.of(6, new int[]{0, 0, 0, 0, 1, 0}, 3),
                Arguments.of(12, new int[]{0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0}, 6),
                Arguments.of(6, new int[]{0, 1, 0, 0, 0, 1, 0}, 3)
        );
    }
}
