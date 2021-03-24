public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode node, int num) {
        if (node == null) return 0;

        num = num * 10 + node.val;

        if (node.left == null && node.right == null) {
            return num;
        }

        return sumNumbers(node.left, num) + sumNumbers(node.right, num);
    }
}