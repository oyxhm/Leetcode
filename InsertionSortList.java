/**
 * Created by yhf on 15/5/19.
 */

/*
Sort a linked list using insertion sort.
*/

public class InsertionSortList {
    public static ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            ListNode p = newHead;
            while (p.next != null && p.next.val < cur.val) {
                p = p.next;
            }
            ListNode temp = p.next;
            p.next = cur;
            cur.next = temp;
            cur = next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n1 = new ListNode(1);
        n4.next = n3;
        n3.next = n2;
        n2.next = n1;
        ListNode head = insertionSortList(n4);
    }
}
