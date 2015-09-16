package src.main;

/**
 * Created by yhf on 9/15/15.
 */

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 *
 * return 1->4->3->2->5->NULL.
 *
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */

public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode leftLast = dummy;
        n -= m;
        while (--m > 0) {
            leftLast = leftLast.next;
        }
        ListNode pre = leftLast.next;
        ListNode cur = pre.next;
        while (n > 0) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            n--;
        }
        ListNode rightFirst = cur;
        leftLast.next.next = rightFirst;
        leftLast.next = pre;
        return dummy.next;
    }
}
