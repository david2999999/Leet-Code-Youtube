public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode sHead = new ListNode(), sTail = sHead, node = head;

        while (node != null) {
            ListNode next = node.next;
            node.next = null;

            if (node.val != val) {
                sTail.next = node;
                sTail = node;
            }

            node = next;
        }

        return sHead.next;
    }
}