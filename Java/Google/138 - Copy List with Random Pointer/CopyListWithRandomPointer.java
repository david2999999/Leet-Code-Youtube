public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        return copyRandomList(head, new HashMap<>());
    }

    private Node copyRandomList(Node node, Map<Node, Node> map) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);

        Node clone = new Node(node.val);
        map.put(node, clone);

        clone.next = copyRandomList(node.next, map);
        clone.random = copyRandomList(node.random, map);

        return clone;
    }
}