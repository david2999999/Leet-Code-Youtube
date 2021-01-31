public class ReverseNodesInKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode sHead = new ListNode(), sTail = sHead;
        ListNode n1 = head, n2 = head;
        int count = 0;

        while (n2 != null) {
            ListNode next = n2.next;
            count++;

            if (count == k) {
                n2.next = null;
                ListNode[] reverse = reversed(n1);
                sTail.next = reverse[0];
                sTail = reverse[1];
                n1 = next;
                count = 0;
            } else if (next == null) {
                sTail.next = n1;
            }

            n2 = next;
        }

        return sHead.next;
    }

    private ListNode[] reversed(ListNode n1) {
        ListNode rHead = null, rTail = null;

        while (n1 != null) {
            ListNode next = n1.next;
            n1.next = rHead;
            rHead = n1;
            n1 = next;

            if (rTail == null) rTail = rHead;
        }

        return new ListNode[] { rHead, rTail };
    }
}