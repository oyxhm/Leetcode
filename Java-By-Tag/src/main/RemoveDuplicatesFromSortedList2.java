package src.main;

/**
 * Created by yhf on 9/15/15.
 */

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */

public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0), cur = dummy;
        dummy.next = head;
        while (cur != null) {
            if (cur.next != null && cur.next.next != null && cur.next.val == cur.next.next.val) {
                ListNode temp = cur;
                cur = cur.next;
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                temp.next = cur.next;
                cur = temp;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
