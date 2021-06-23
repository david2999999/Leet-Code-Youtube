public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode reverse = null, node = head;

        while (node != null) {
            ListNode next = node.next;
            node.next = reverse;
            reverse = node;
            node = next;
        }

        return reverse;
    }
}