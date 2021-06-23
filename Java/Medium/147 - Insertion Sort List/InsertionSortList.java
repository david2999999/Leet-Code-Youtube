public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode sHead = new ListNode(0), node = head;

        while (node != null) {
            ListNode next = node.next, cur = sHead;
            node.next = null;

            while (cur.next != null && cur.next.val <= node.val) cur = cur.next;

            node.next = cur.next;
            cur.next = node;
            node = next;
        }

        return sHead.next;
    }
}