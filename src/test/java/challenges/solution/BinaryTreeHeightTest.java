package challenges.solution;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BinaryTreeHeightTest {
    @Test
    public void should_find_binary_tree_height() {
        Node root = null;
        int t = 5;
        int expectedHeight = 4;
        while(t-- > 0) {
            root = BinaryTreeHeight.insert(root, t);
        }

        int height = BinaryTreeHeight.height(root);

        assertThat("Expected minimal win steps count: [" + expectedHeight + "]. But received wrong value: [" + height + "]",
                expectedHeight, is(height));
    }
}
