package challenges.solution;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckBSTTest {
    @Test
    public void should_verify_bst() {
        Node root = null;
        int t = 6;
        int[] data = new int[]{4, 2, 3, 1, 7, 6};
        int k = 0;
        while (t-- > 0) {
            root = BinaryTreeHeight.insert(root, data[k++]);
        }

        boolean isActualBst = CheckBST.checkBST(root);

        assertThat(isActualBst, is(true));
    }
}
