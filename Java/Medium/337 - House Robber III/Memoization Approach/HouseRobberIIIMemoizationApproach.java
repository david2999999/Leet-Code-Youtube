public class HouseRobberIIIMemoizationApproach {
    public int rob(TreeNode node) {
        return rob(node, new HashMap<>());
    }

    private int rob(TreeNode node, Map<TreeNode, Integer> memo) {
        if (node == null) return 0;
        if (memo.containsKey(node)) return memo.get(node);

        int m1 = node.val +
            (node.left == null ? 0 : rob(node.left.left, memo) + rob(node.left.right, memo)) +
            (node.right == null ? 0 : rob(node.right.left, memo) + rob(node.right.right, memo));
        int m2 = rob(node.left, memo) + rob(node.right, memo);

        memo.put(node, Math.max(m1, m2));
        return Math.max(m1, m2);
    }
}