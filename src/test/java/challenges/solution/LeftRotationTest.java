package challenges.solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LeftRotationTest {
    @ParameterizedTest
    @MethodSource("provideTestArguments")
    public void isArrayLeftRotated(int[] arr, int shiftIndex, int[] expectedArray) {
        int[] actualArray = LeftRotation.rotLeft(arr, shiftIndex);
        assertThat(actualArray, is(expectedArray));
    }

    private static Stream<Arguments> provideTestArguments() {
        return Stream.of(
                Arguments.of(new int[]{98, 67, 35, 1, 74, 79, 7, 26}, 2, new int[]{ 35, 1, 74, 79, 7, 26, 98, 67}),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 4, new int[]{5, 1, 2, 3, 4}),
                Arguments.of(new int[]{33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60, 87, 97}, 13,
                        new int[]{87, 97, 33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60})
        );
    }
}
