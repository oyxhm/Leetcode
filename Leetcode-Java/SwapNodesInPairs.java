/**
 * Created by yhf on 15/5/16.
 */

/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/

public class SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head, ret = head.next;
        while (p != null && p.next != null) {
            ListNode temp = p.next.next;
            p.next.next = p;
            if (temp != null) {
                if (temp.next != null) {
                    p.next = temp.next;
                } else {
                    p.next = temp;  // 奇数个节点， 处理最后一个节点
                }
            } else {
                p.next = null;
            }
            p = temp;
        }
        return ret;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        ListNode head = swapPairs(n1);
    }
}
