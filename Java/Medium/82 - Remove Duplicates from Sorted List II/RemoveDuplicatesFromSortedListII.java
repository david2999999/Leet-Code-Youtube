public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sHead = new ListNode(), sTail = sHead, node = head;

        while (node != null) {
            if (node.next != null && node.val == node.next.val) {
                while (node.next != null && node.val == node.next.val) {
                    node = node.next;
                }

                node = node.next;
                continue;
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