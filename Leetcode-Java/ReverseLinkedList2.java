/**
 * Created by yhf on 15/5/17.
 */

/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
*/

public class ReverseLinkedList2 {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode p = head, start = null;  // start is previous node of the head of the reversed list
        int i = 0;
        while (++i < m) {
            if (i == m - 1) {
                start = p;
            }
            p = p.next;
        }
        ListNode newHead = p, q = p.next;  // newHead is the head of the list to be reversed
        while (i < n) {
            ListNode temp = q.next;
            q.next = p;
            p = q;
            q = temp;
            i++;
        }
        newHead.next = q;     // newHead becomes the tail of the reversed list
        if (start == null) {  // m == 1
            return p;
        } else {
            start.next = p;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode head = reverseBetween(n1, 2, 5);
    }
}
