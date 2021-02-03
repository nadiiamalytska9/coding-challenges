package challenges.solution;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BinaryTreeHeightTest {
    @Test
    public void should_find_binary_tree_height() {
        Node root = null;
        int t = 5;
        int expectedHeight = 4;
        while (t-- > 0) {
            root = BinaryTreeHeight.insert(root, t);
        }

        int height = BinaryTreeHeight.height(root);

        assertThat(height, is(expectedHeight));
    }
}
