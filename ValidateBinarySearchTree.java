/**
 * Created by yhf on 15/5/17.
 */

/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
*/

public class ValidateBinarySearchTree {
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        return root.val > min && root.val < max && isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2147483647);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(20);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        boolean isBST = isValidBST(n1);
    }
}
