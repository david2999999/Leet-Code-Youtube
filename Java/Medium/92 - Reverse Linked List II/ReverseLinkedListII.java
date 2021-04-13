public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode sHead = new ListNode(), sTail = sHead;
        ListNode rHead = null, rTail = null, node = head;
        int i = 0;

        while (node != null) {
            ListNode next = node.next;
            node.next = null;
            i++;

            if (i < left || i > right) {
                sTail.next = node;
                sTail = node;
            } else {
                if (rTail == null) rTail = node;

                node.next = rHead;
                rHead = node;

                if (i + 1 > right) {
                    sTail.next = rHead;
                    sTail = rTail;
                }
            }

            node = next;
        }

        return sHead.next;
    }
}