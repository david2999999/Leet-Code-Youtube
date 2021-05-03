public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int x = getLength(headA), y = getLength(headB);
        ListNode shorter = (x < y) ? headA : headB;
        ListNode longer = (x < y) ? headB : headA;

        longer = moveForward(longer, Math.abs(x - y));

        while (shorter != null && shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        return shorter;
    }

    private ListNode moveForward(ListNode head, int steps) {
        ListNode node = head;

        while (steps-- > 0) {
            node = node.next;
        }

        return node;
    }

    private int getLength(ListNode head) {
        int length = 0;

        for (ListNode node = head; node != null; node = node.next) {
            length++;
        }

        return length;
    }
}