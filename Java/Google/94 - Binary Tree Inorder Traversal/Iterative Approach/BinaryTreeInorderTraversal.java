public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        pushAllNodesOnLeftPath(root, stack);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            pushAllNodesOnLeftPath(node.right, stack);
        }

        return result;
    }

    private void pushAllNodesOnLeftPath(TreeNode root, Deque<TreeNode> stack) {
        for (TreeNode node = root; node != null; node = node.left) {
            stack.push(node);
        }
    }
}