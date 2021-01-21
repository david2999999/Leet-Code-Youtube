public class MinDepthBinaryTree {
    public int minDepth(TreeNode root) {
        return root == null ? 0 : getMinDepth(root);
    }

    private int getMinDepth(TreeNode node) {
        if (node == null) return Integer.MAX_VALUE;
        if (node.left == null && node.right == null) return 1;

        return Math.min(getMinDepth(node.left), getMinDepth(node.right)) + 1;
    }
}