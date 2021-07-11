public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int n = 0;
        pushAllNodesOnLeftPath(root, stack);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            n++;

            if (n == k) return node.val;

            pushAllNodesOnLeftPath(node.right, stack);
        }

        return -1;
    }

    private void pushAllNodesOnLeftPath(TreeNode root, Deque<TreeNode> stack) {
        for (TreeNode node = root; node != null; node = node.left) stack.push(node);
    }
}