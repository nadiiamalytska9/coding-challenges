package challenges.solution;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LowestCommonAncestorTest {
    @Test
    public void should_find_lowest_common_ancestor() {
        Node root = null;
        int t = 6;
        int expectedHeight = 4;
        int[] data = new int[]{4, 2, 3, 1, 7, 6};
        int k = 0;
        while (t-- > 0) {
            root = BinaryTreeHeight.insert(root, data[k++]);
        }

        int actualCommonAncestor = LowestCommonAncestor.lca(root, 1, 7).data;

        assertThat(actualCommonAncestor, is(expectedHeight));
    }
}
