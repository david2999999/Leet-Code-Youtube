public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, new ArrayList<>(), 0, targetSum, result);
        return result;
    }

    private void pathSum(TreeNode node, List<Integer> path, int sum, int targetSum, List<List<Integer>> result) {
        if (node == null) return;

        sum += node.val;
        path.add(node.val);

        if (node.left == null && node.right == null && sum == targetSum) {
            result.add(new ArrayList<>(path));
        }

        pathSum(node.left, path, sum, targetSum, result);
        pathSum(node.right, path, sum, targetSum, result);
        path.remove(path.size() - 1);
    }
}