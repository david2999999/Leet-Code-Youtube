public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode p = queue.poll(), q = queue.poll();

            if (p == null && q == null) continue;
            if ((p == null || q == null) || (p.val != q.val)) return false;

            queue.add(p.left); queue.add(q.right);
            queue.add(p.right); queue.add(q.left);
        }

        return true;
    }
}