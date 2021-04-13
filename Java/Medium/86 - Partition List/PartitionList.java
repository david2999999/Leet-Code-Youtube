public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode h1 = new ListNode(), t1 = h1;
        ListNode h2 = new ListNode(), t2 = h2, node = head;

        while (node != null) {
            ListNode next = node.next;
            node.next = null;

            if (node.val < x) {
                t1.next = node;
                t1 = node;
            } else {
                t2.next = node;
                t2 = node;
            }

            node = next;
        }

        t1.next = h2.next;
        return h1.next;
    }
}