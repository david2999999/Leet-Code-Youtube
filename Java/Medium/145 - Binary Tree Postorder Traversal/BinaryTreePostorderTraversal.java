public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        postorderTraversal(root, values);
        return values;
    }

    private void postorderTraversal(TreeNode node, List<Integer> values) {
        if (node == null) return;

        postorderTraversal(node.left, values);
        postorderTraversal(node.right, values);
        values.add(node.val);
    }
}