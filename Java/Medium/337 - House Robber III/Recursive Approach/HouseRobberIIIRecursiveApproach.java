public class HouseRobberIIIRecursiveApproach {
    public int rob(TreeNode node) {
        if (node == null) return 0;

        int m1 = node.val +
            (node.left == null ? 0 : rob(node.left.left) + rob(node.left.right)) +
            (node.right == null ? 0 : rob(node.right.left) + rob(node.right.right));
        int m2 = rob(node.left) + rob(node.right);

        return Math.max(m1, m2);
    }
}