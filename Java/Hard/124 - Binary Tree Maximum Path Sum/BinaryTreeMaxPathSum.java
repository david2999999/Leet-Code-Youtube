public class BinaryTreeMaxPathSum {
    private class MaxSum {
        public int value = Integer.MIN_VALUE;
    }

    public int maxPathSum(TreeNode root) {
        MaxSum maxSum = new MaxSum();
        maxPathSum(root, maxSum);
        return maxSum.value;
    }

    private int maxPathSum(TreeNode node, MaxSum maxSum) {
        if (node == null) return 0;

        int left = Math.max(maxPathSum(node.left, maxSum), 0);
        int right = Math.max(maxPathSum(node.right, maxSum), 0);
        maxSum.value = Math.max(maxSum.value, node.val + left + right);

        return Math.max(node.val + left, node.val + right);
    }
}