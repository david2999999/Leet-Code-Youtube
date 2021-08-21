public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode oHead = new ListNode(), oTail = oHead;
        ListNode eHead = new ListNode(), eTail = eHead, node = head;
        boolean isOdd = true;

        while (node != null) {
            ListNode next = node.next;
            node.next = null;

            if (isOdd) {
                oTail.next = node;
                oTail = node;
            } else {
                eTail.next = node;
                eTail = node;
            }

            isOdd = !isOdd;
            node = next;
        }

        oTail.next = eHead.next;
        return oHead.next;
    }
}