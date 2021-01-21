public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != Integer.MAX_VALUE;
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;

        int left = getHeight(node.left);
        int right = getHeight(node.right);

        if (left == Integer.MAX_VALUE || right == Integer.MAX_VALUE ||
                Math.abs(left - right) > 1) {
            return Integer.MAX_VALUE;
        }

        return Math.max(left, right) + 1;
    }
}