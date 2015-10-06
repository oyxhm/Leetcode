package src.main;

/**
 * Created by yhf on 10/6/15.
 */

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 *
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */

public class RotateList {
    // Cases:
    // 1. head is null, len = 0
    // 2. k is divided by len
    // 3. k greater than len

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        int len = getLength(head);
        k %= len;
        if (k == 0) {
            return head;
        }
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }

    private int getLength(ListNode head) {
        ListNode n = head;
        int len = 0;
        while (n != null) {
            n = n.next;
            len++;
        }
        return len;
    }
}
