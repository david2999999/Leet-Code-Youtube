public class PopulatingNextRightPointerII {
    public Node connect(Node root) {
        Node node = root;

        while (node != null) {
            Node left = null, prev = null, x = node;

            while (x != null) {
                if (x.left != null) {
                    if (left == null) left = x.left;

                    if (prev != null) {
                        prev.next = x.left;
                        prev = x.left;
                    } else {
                        prev = x.left;
                    }
                }

                if (x.right != null) {
                    if (left == null) left = x.right;

                    if (prev != null) {
                        prev.next = x.right;
                        prev = x.right;
                    } else {
                        prev = x.right;
                    }
                }

                x = x.next;
            }

            node = left;
        }

        return root;
    }
}