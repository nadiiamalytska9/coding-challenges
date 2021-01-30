package challenges.solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SocksMerchantSolutionTest {

    @ParameterizedTest
    @MethodSource("provideTestArguments")
    public void isSocksComputingRight(int socksAmount, int[] socks, int expectedPairsNumber) {
        int actualPairsNumber = SocksMerchantSolution.sockMerchant(socksAmount, socks);
        assertThat("Socks pairs number [" + expectedPairsNumber + "] and [" + actualPairsNumber + "] are different!",
                expectedPairsNumber, is(actualPairsNumber));
    }

    private static Stream<Arguments> provideTestArguments() {
        return Stream.of(
                Arguments.of(9, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20}, 3),
                Arguments.of(15, new int[]{6, 5, 2, 3, 5, 2, 2, 1, 1, 5, 1, 3, 3, 3, 5}, 6),
                Arguments.of(12, new int[]{10, 10, 10, 11, 12, 14, 14, 12, 15, 10, 15, 18}, 5),
                Arguments.of(20, new int[]{1, 2, 1, 1, 3, 1, 2, 2, 3, 15, 3, 4, 4, 4, 4, 4, 7, 9, 9, 1}, 7)
        );
    }
}
