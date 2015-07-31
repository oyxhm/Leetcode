import java.util.List;

/**
 * Created by yhf on 15/4/14.
 */
/*

You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4) + (5 -> 6 -> 9 -> 9)
Output: 7 -> 0 -> 0 -> 0 - > 1
*/

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1, n2 = l2;
        ListNode ret = new ListNode(0), head = ret;
        boolean flag = false;
        while (n1 != null && n2 != null) {
            int num = n1.val + n2.val;
            if (flag) {
                num++;
            }
            if (num >= 10) {
                num -= 10;
                flag = true;
            } else {
                flag = false;
            }
            ListNode n = new ListNode(num);
            head.next = n;
            head = head.next;

            n1 = n1.next;
            n2 = n2.next;
        }
        while (n1 != null) {
            int num = n1.val;
            if (flag) {
                num++;
            }
            if (num >= 10) {
                num -= 10;
                flag = true;
            } else {
                flag = false;
            }
            ListNode n = new ListNode(num);
            head.next = n;
            head = head.next;
            n1 = n1.next;
        }
        while (n2 != null) {
            int num = n2.val;
            if (flag) {
                num++;
            }
            if (num >= 10) {
                num -= 10;
                flag = true;
            } else {
                flag = false;
            }
            ListNode n = new ListNode(num);
            head.next = n;
            head = head.next;
            n2 = n2.next;
        }
        if (flag) {
            ListNode n = new ListNode(1);
            head.next = n;
        }
        return ret.next;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode n1 = l1, n2 = l2, head = new ListNode(0), ret = head;
        while (n1 != null || n2 != null) {
            int num = 0;
            if (n1 != null) {
                num += n1.val;
                n1 = n1.next;
            }
            if (n2 != null) {
                num += n2.val;
                n2 = n2.next;
            }
            num += carry;
            carry = num / 10;
            ListNode n = new ListNode(num % 10);
            head.next = n;
            head = head.next;
        }
        if (carry == 1) {
            head.next = new ListNode(1);
        }
        return ret.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(9);
        ListNode n7 = new ListNode(9);
        n1.next = n2;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        ListNode n = addTwoNumbers2(n1, n4);
        int a = 1;
    }
}
