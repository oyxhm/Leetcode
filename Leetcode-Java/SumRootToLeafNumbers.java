/**
 * Created by yhf on 15/5/1.
 */

/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
*/

public class SumRootToLeafNumbers {
    public static int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public static int sumNumbers(TreeNode root, int sum) {
        if (root == null) {
            return 0;    // 这里一定要注意，return 0，不是return sum
        } else if (root.left == null && root.right == null) {
            return sum * 10 + root.val;
        } else {
            return sumNumbers(root.left, sum * 10 + root.val) + sumNumbers(root.right, sum * 10 + root.val);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        System.out.println(sumNumbers(t1));
    }
}
