package src.main;

/**
 * Created by yhf on 8/27/15.
 */

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or
 * equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0), greater = new ListNode(0);
        ListNode lessHead = less, greaterHead = greater;
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }
        less.next = greaterHead.next;
        greater.next = null;
        return lessHead.next;
    }
}
