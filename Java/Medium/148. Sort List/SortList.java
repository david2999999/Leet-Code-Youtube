public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode head2 = getHeadOfUpperHalf(head);
        return merge(sortList(head), sortList(head2));
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode sHead = new ListNode(), sTail = sHead;

        while (left != null || right != null) {
            if (right == null || (left != null && left.val <= right.val)) {
                sTail.next = left;
                sTail = left;
                left = left.next;
            } else {
                sTail.next = right;
                sTail = right;
                right = right.next;
            }
        }

        return sHead.next;
    }

    private ListNode getHeadOfUpperHalf(ListNode head) {
        ListNode slow = head, fast = head, prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        return slow;
    }
}