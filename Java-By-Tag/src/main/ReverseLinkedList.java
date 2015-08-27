package src.main;

/**
 * Created by yhf on 8/25/15.
 */

import java.util.List;

/**
 * Reverse a singly linked list.
 *
 * Hint:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = head, cur = head.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = null;
        return pre;
    }
}
