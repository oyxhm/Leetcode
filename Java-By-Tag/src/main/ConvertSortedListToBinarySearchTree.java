package src.main;

/**
 * Created by yhf on 8/27/15.
 */

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */

public class ConvertSortedListToBinarySearchTree {
    private ListNode cur;

    public TreeNode sortedListToBST(ListNode head) {
        cur = head;
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return sortedListToBST(0, len - 1);
    }

    private TreeNode sortedListToBST(int low, int high) {
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
}
