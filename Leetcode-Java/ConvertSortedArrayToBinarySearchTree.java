/**
 * Created by yhf on 15/5/14.
 */

/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*/

public class ConvertSortedArrayToBinarySearchTree {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = sortedArrayToBST(new int[] {1, 2, 3, 4, 5, 6});
    }
}
