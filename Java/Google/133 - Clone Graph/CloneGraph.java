public class CloneGraph {
    public Node cloneGraph(Node node) {
        return cloneGraph(node, new HashMap<>());
    }

    private Node cloneGraph(Node node, Map<Node, Node> map) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);

        Node clone = new Node(node.val);
        map.put(node, clone);

        for (Node neighbor: node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor, map));
        }

        return clone;
    }
}