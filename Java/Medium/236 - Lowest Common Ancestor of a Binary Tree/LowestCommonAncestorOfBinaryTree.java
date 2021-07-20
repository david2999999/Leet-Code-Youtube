public class LowestCommonAncestorOfBinaryTree {
    private class Ancestor {
        public TreeNode node = null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Ancestor ancestor = new Ancestor();
        lowestCommonAncestor(root, p, q, ancestor);
        return ancestor.node;
    }

    private boolean lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q, Ancestor ancestor) {
        if (node == null) return false;

        boolean left = lowestCommonAncestor(node.left, p, q, ancestor);
        boolean right = lowestCommonAncestor(node.right, p, q, ancestor);
        boolean current = (node == p) || (node == q);

        if ((left && right) || ((left || right) && current)) {
            ancestor.node = node;
            return false;
        }

        return left || right || current;
    }
}