public class BalancedBinaryTree {
    public int minDepth(TreeNode root) {
        return root == null ? 0 : getMinDepth(root);
    }

    private int getMinDepth(TreeNode node) {
        if (node == null) return Integer.MAX_VALUE;
        if (node.left == null && node.right == null) return 1;

        int left = getMinDepth(node.left);
        int right = getMinDepth(node.right);

        return Math.min(left, right) + 1;
    }
}