public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sHead = new ListNode(), node = head;
        ListNode sTail = sHead;

        while (node != null) {
            while (node.next != null && node.next.val == node.val) {
                node = node.next;
            }

            ListNode next = node.next;
            node.next = null;
            sTail.next = node;
            sTail = node;
            node = next;
        }

        return sHead.next;
    }
}