public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode sHead = new ListNode(), sTail = sHead, node = head;

        while (node != null) {
            ListNode next = (node.next == null) ? null : node.next.next;

            if (node.next == null) {
                sTail.next = node;
                sTail = node;
            } else {
                node.next.next = null;
                sTail.next = node.next;
                sTail = node.next;

                node.next = null;
                sTail.next = node;
                sTail = node;
            }

            node = next;
        }

        return sHead.next;
    }
}