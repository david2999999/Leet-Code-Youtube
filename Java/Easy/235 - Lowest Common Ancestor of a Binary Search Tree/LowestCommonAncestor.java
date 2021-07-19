public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;

        while (node != null) {
            if (node == p || node == q) return node;

            boolean pIsOnLeft = p.val < node.val;
            boolean qIsOnLeft = q.val < node.val;

            if (pIsOnLeft != qIsOnLeft) {
                return node;
            } else {
                node = pIsOnLeft ? node.left : node.right;
            }
        }

        return null;
    }
}