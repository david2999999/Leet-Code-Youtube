public class PopulatingNextRightPointer {
    public Node connect(Node root) {
        if (root == null) return root;

        Node node = root;

        while (node.left != null) {
            Node left = node.left, x = node;

            while (x != null) {
                x.left.next = x.right;

                if (x.next != null) {
                    x.right.next = x.next.left;
                }

                x = x.next;
            }

            node = left;
        }

        return root;
    }
}