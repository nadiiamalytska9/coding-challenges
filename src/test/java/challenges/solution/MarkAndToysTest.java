package challenges.solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MarkAndToysTest {
    @ParameterizedTest
    @MethodSource("provideTestArguments")
    public void isBoughTheMaximumToysNumber(int budget, int[] toys, int expectedToysNumber) {
        int actualToysNumber = MarkAndToys.maximumToys(toys, budget);
        assertThat("Expected maximum number of toys: [" + expectedToysNumber + "]. But received wrong value: [" + actualToysNumber + "]",
                actualToysNumber, is(expectedToysNumber));
    }

    private static Stream<Arguments> provideTestArguments() {
        return Stream.of(
                Arguments.of(50, new int[]{1, 12, 5, 111, 200, 1000, 10}, 4),
                Arguments.of(7, new int[]{1, 2, 3, 4}, 3),
                Arguments.of(100000, new int[]{52952808, 39586066, 70403274, 84627963, 46636834, 13906132, 440}, 1)
        );
    }
}
