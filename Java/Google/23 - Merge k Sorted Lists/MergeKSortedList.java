public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = createMinHeap(lists);
        ListNode head = new ListNode(), tail = head;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            tail.next = node;
            tail = node;

            if (node.next != null) {
                minHeap.add(node.next);
            }
        }

        return head.next;
    }

    private PriorityQueue<ListNode> createMinHeap(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);

        for (ListNode list: lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }

        return minHeap;
    }
}