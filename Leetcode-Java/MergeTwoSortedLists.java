/**
 * Created by yhf on 15/6/15.
 */

/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
*/

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if (head1 != null) {
            cur.next = head1;
        }
        if (head2 != null) {
            cur.next = head2;
        }
        return head.next;
    }

    public static void main() {

    }
}
