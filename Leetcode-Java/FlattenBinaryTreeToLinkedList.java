/**
 * Created by yhf on 15/5/8.
 */

/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given
         1
        / \
       2   5
      / \   \
     3   4   6

The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
*/

/*
* 1. 先把本次访问right的存下来
* 2. lastVisit.left设为null，lastVisit.right设为root
* 3. 递归，先序遍历
* */

public class FlattenBinaryTreeToLinkedList {
    private static TreeNode lastVisit = null;

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode saveRight = root.right;
        if (lastVisit != null) {
            lastVisit.left = null;
            lastVisit.right = root;
        }
        lastVisit = root;
        flatten(root.left);
        flatten(saveRight);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
        n2.left = n3;
        n2.right = n4;
        n1.right = n5;
        n5.right = n6;
        flatten(n1);
    }
}
