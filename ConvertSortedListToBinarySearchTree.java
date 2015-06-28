import java.util.LinkedList;

/**
 * Created by yhf on 15/6/28.
 */

/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/

public class ConvertSortedListToBinarySearchTree {
    private static ListNode cur;

    public static TreeNode sortedListToBST(ListNode head) {
        cur = head;
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return sortedListToBST(0, len - 1);
    }

    private static TreeNode sortedListToBST(int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            TreeNode left = sortedListToBST(low, mid - 1);
            TreeNode root = new TreeNode(cur.val);
            cur = cur.next;
            root.left = left;
            root.right = sortedListToBST(mid + 1, high);
            return root;
        } else {
            return null;
        }
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

        TreeNode root = sortedListToBST(n1);
    }
}
