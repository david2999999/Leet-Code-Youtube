public class BSTIterator {
    private Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new ArrayDeque<>();
        pushAllNodesOnLeftPath(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        pushAllNodesOnLeftPath(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAllNodesOnLeftPath(TreeNode root) {
        for (TreeNode node = root; node != null; node = node.left) {
            stack.push(node);
        }
    }
}