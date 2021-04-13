public class BinaryTreeLevelZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isRight = true;
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> values = new LinkedList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (isRight) {
                    values.add(node.val);
                } else {
                    values.add(0, node.val);
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            result.add(values);
            isRight = !isRight;
        }

        return result;
    }
}