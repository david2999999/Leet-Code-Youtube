public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, 0, targetSum);
    }

    private boolean hasPathSum(TreeNode node, int sum, int targetSum) {
        if (node == null) return false;

        sum += node.val;

        if (node.left == null && node.right == null) {
            return sum == targetSum;
        }

        return hasPathSum(node.left, sum, targetSum) ||
               hasPathSum(node.right, sum, targetSum);
    }
}