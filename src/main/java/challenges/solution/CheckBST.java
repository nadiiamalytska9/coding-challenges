package challenges.solution;

import java.util.HashSet;
import java.util.Set;

public class CheckBST {
    public static boolean checkBST(Node root) {
        Set<Integer> bstData = new HashSet<>();
        if (!bstData.add(root.data)) {
            return false;
        }
        if (root.left == null || root.right == null) {
            return true;
        }
        if (root.data > root.right.data || root.data < root.left.data) {
            return false;
        }
        checkBST(root.left);
        checkBST(root.right);
        return true;
    }
}
