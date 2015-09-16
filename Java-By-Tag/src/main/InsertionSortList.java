package src.main;

/**
 * Created by yhf on 9/15/15.
 */

/**
 * Sort a linked list using insertion sort.
 */

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode cur = dummy;
            while (cur.next != null && cur.next.val <= head.val) {
                cur = cur.next;
            }
            ListNode temp = head.next;
            head.next = cur.next;
            cur.next = head;
            head = temp;
        }
        return dummy.next;
    }
}
