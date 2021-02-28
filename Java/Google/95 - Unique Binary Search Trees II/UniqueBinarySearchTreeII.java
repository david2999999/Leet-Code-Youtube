public class UniqueBinarySearchTreeII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();

        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int left, int right) {
        List<TreeNode> roots = new ArrayList<>();

        if (left > right) {
            roots.add(null);
        } else {
            for (int i = left; i <= right; i++) {
                List<TreeNode> leftSubtrees = generateTrees(left, i - 1);
                List<TreeNode> rightSubtrees = generateTrees(i + 1, right);

                for (TreeNode leftSubtree: leftSubtrees) {
                    for (TreeNode rightSubtree: rightSubtrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftSubtree;
                        root.right = rightSubtree;
                        roots.add(root);
                    }
                }
            }
        }

        return roots;
    }
}