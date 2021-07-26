public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        binaryTreePaths(root, new StringBuilder(), paths);
        return paths;
    }

    private void binaryTreePaths(TreeNode node, StringBuilder path, List<String> paths) {
        if (node == null) return;

        int length = path.length();
        path.append(node.val);

        if (node.left == null && node.right == null) paths.add(path.toString());

        path.append("->");
        binaryTreePaths(node.left, path, paths);
        binaryTreePaths(node.right, path, paths);
        path.setLength(length);
    }
}