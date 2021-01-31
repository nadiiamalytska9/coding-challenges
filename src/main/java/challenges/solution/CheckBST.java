package challenges.solution;

public class CheckBST {
    public static boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static boolean checkBST(Node node, int min, int max) {
        if (node == null) return true;
        return  min < node.data && node.data < max &&
                checkBST(node.left, min, node.data) &&
                checkBST(node.right, node.data, max);
    }
}
