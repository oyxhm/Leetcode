/**
 * Created by yhf on 15/5/13.
 */

/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/

public class ReorderList {
    public static void reorderList(ListNode head) {
        // 超时
        if (head == null || head.next == null) {
            return;
        }
        int steps = 0;
        ListNode p = head.next;
        while (p != null) {
            p = p.next;
            steps++;
        }
        ListNode left = head;
        while (steps >= 2) {
            ListNode right = left;
            int count = steps;
            while (count-- > 0) {
                right = right.next;
            }
            ListNode temp = left.next;
            left.next = right;
            left = temp;
            right.next = left;
            steps -= 2;
            if (steps == 0) {
                left.next = null;
            }
            if (steps == 1) {
                left.next.next = null;
            }
        }
    }

    public static void reorderList2(ListNode head) {
        // 1. split into two lists
        // 2. reverse the second list
        // 3. merge two lists

        if (head == null) {
            return;
        }

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode head1 = head;
        head2 = reverseList(head2);
        while (head2 != null) {
            ListNode temp = head.next;
            ListNode temp2 = head2.next;
            head.next = head2;
            head2.next = temp;
            head = temp;
            head2 = temp2;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head.next;
        head.next = null;
        while (p != null) {
            ListNode temp = p.next;
            p.next = head;
            head = p;
            p = temp;
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
        reorderList2(n1);
    }
}
