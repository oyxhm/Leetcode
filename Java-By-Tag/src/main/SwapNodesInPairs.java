package src.main;

/**
 * Created by yhf on 8/25/15.
 */

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be
 * changed.
 */

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            ListNode temp = cur.next.next;
            pre.next = cur.next;
            cur.next.next = cur;
            cur.next = temp;
            pre = cur;
            cur = temp;
        }

        return dummy.next;
    }
}
