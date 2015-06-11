/**
 * Created by yhf on 15/6/10.
 */

/*
Given a complete binary tree, count the number of nodes.

In a complete binary tree every level, except possibly the last, is completely filled, and all nodes
in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the
last level h.
*/

public class CountCompleteTreeNodes {
    public static int countNodes(TreeNode root) {
        // Time Limit Exceeded
        // Special Judge: very large tree
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static int countNodes2(TreeNode root) {
        int height = height(root);
        double count = Math.pow(2, height) - 1;
        height -= 2;
        while (root != null) {
            if (height(root.left) == height(root.right)) {
                root = root.right;
            } else {
                root = root.left;
                count -= Math.pow(2, height);
            }
            height--;
        }
        return (int) count;
    }

    private static int height(TreeNode root) {
        return root == null ? 0 : 1 + height(root.left);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        int count = countNodes2(n1);
    }
}
