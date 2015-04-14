/**
 * Created by yhf on 15/4/14.
 */

/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
*/

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class RemoveNthNodeFromEndOfList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while (n-- != 0) {
            fast = fast.next;
        }
        if (fast == null) {
            // the node to remove is head
            return head.next;
        }
        ListNode slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        /*ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;*/
        ListNode n = removeNthFromEnd(n1, 1);
        int a = 1;
    }
}
