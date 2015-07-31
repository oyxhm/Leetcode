/**
 * Created by yhf on 15/4/16.
 */

/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in
which the depth of the two subtrees of every node never differ by more than 1.

       5
      / \
     4   8
    /   / \
  11  13   4
 /  \       \
7    2       1

*/

public class BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalancedNode(root) && isBalanced(root.left) && isBalanced(root.right);
    }

    public static boolean isBalancedNode(TreeNode root) {
        if (root == null) {
            return true;
        }
        return !(Math.abs(depth(root.right) - depth(root.left)) > 1);
    }

    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        n4.left = n7;
        n4.right = n8;
        n6.right = n9;
        System.out.println(isBalanced(n1));
    }
}
