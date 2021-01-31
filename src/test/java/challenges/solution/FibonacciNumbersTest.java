package challenges.solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FibonacciNumbersTest {
    @ParameterizedTest
    @MethodSource("provideTestArguments")
    public void isMinimalWinStepsCountRight(int n, int expectedFibonacciSum) {
        int actualFibonacciSum = FibonacciNumbers.fibonacci(n);
        assertThat("Expected fibonacci sum: [" + expectedFibonacciSum + "]. But received wrong value: [" + actualFibonacciSum + "]",
                actualFibonacciSum, is(expectedFibonacciSum));
    }

    private static Stream<Arguments> provideTestArguments() {
        return Stream.of(
                Arguments.of(5, 5), Arguments.of(12, 144), Arguments.of(17, 1597), Arguments.of(30, 832040)
        );
    }
}
