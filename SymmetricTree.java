import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhf on 15/4/17.
 */

/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
*/

import java.util.*;

public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        // recursive method
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        // 对称的条件：
        // 1. 左右子树均为null
        // 2. 左结点的左子树与右结点的右子树对称
        // 3. 左结点的右子树与右结点的左子树对称
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public static boolean isSymmetric2(TreeNode root) {
        // iteratively
        if (root == null) {
            return true;
        }
        Queue<TreeNode> lQueue = new LinkedList<TreeNode>(),
                        rQueue = new LinkedList<TreeNode>();
        lQueue.add(root.left);
        rQueue.add(root.right);
        while (!lQueue.isEmpty() || !rQueue.isEmpty()) {
            TreeNode l = lQueue.poll(),
                     r = rQueue.poll();
            if (l == null && r == null) {
                continue;
            }
            if (l == null && r != null || l != null && r == null || l.val != r.val) {
                return false;
            }
            lQueue.add(l.left);
            lQueue.add(l.right);
            rQueue.add(r.right);
            rQueue.add(r.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        System.out.println(isSymmetric2(n1));
    }
}
