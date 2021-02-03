package challenges.solution;

import org.junit.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BubbleSortTest {
    @Test
    public void should_sort_array() throws Exception {
        int[] arr = new int[]{3, 2, 1};

        String actualOutput = tapSystemOut(() -> {
            BubbleSort.countSwaps(arr);
        });
        String expectedOutput = "Array is sorted in 3 swaps. First Element: 1 Last Element: 3\n";
        assertThat(actualOutput, is(expectedOutput));
    }
}
