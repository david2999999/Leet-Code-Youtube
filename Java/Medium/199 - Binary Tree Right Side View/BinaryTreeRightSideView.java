public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideView(root, result, 0);
        return result;
    }

    private void rightSideView(TreeNode node, List<Integer> result, int level) {
        if (node == null) return;

        if (level == result.size()) result.add(node.val);

        rightSideView(node.right, result, level + 1);
        rightSideView(node.left, result, level + 1);
    }
}