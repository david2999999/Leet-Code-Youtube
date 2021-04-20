public class BinaryTreePreorderTraversalRecursive {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        preorderTraversal(root, values);
        return values;
    }

    private void preorderTraversal(TreeNode node, List<Integer> values) {
        if (node == null) return;

        values.add(node.val);
        preorderTraversal(node.left, values);
        preorderTraversal(node.right, values);
    }
}