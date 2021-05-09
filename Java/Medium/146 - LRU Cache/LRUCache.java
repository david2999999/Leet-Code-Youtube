public class LRUCache {
    private Map<Integer, DoublyNode> map;
    private DoublyLinkedList nodes;
    private int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.nodes = new DoublyLinkedList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        DoublyNode node = map.get(key);
        nodes.remove(node);
        nodes.addFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            DoublyNode node = new DoublyNode(key, value);
            map.put(key, node);
            nodes.addFirst(node);

            if (map.size() > capacity) {
                DoublyNode lastNode = nodes.removeLast();
                map.remove(lastNode.key);
            }
        } else {
            DoublyNode node = map.get(key);
            nodes.remove(node);
            nodes.addFirst(node);
            node.value = value;
        }
    }

    private class DoublyNode {
        public int key;
        public int value;
        public DoublyNode next = null;
        public DoublyNode prev = null;

        public DoublyNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private class DoublyLinkedList {
        private DoublyNode head;
        private DoublyNode tail;

        public DoublyLinkedList() {
            this.head = new DoublyNode(0, 0);
            this.tail = new DoublyNode(0, 0);
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        public void addFirst(DoublyNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        public DoublyNode remove(DoublyNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
            return node;
        }

        public DoublyNode removeLast() {
            return remove(tail.prev);
        }
    }
}