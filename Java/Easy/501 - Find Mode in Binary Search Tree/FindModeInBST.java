public class FindModeInBST {
    private class ModeHelper {
        public int mode = 0;
        public Integer num = null;
        public int count = 0;
    }

    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();
        inorderTraversal(root, modes, new ModeHelper());
        return modes.stream().mapToInt(i -> i).toArray();
    }

    private void inorderTraversal(TreeNode node, List<Integer> modes, ModeHelper helper) {
        if (node == null) return;

        inorderTraversal(node.left, modes, helper);
        visit(node, modes, helper);
        inorderTraversal(node.right, modes, helper);
    }

    private void visit(TreeNode node, List<Integer> modes, ModeHelper helper) {
        if (helper.num == null || helper.num != node.val) {
            helper.num = node.val;
            helper.count = 0;
        }

        helper.count++;

        if (helper.count > helper.mode) {
            modes.clear();
            modes.add(helper.num);
            helper.mode = helper.count;
        } else if (helper.count == helper.mode) {
            modes.add(helper.num);
        }
    }
}