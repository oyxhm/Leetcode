/**
 * Created by yhf on 15/4/16.
 */

/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
     3
    / \
   9  20
     /  \
    15   7
return11 its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
        if (root == null) {
            return levelOrder;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int numLastLevel = 1, numCurLevel = 0;
        List<Integer> level = new ArrayList<Integer>();
        while (queue.size() != 0) {
            TreeNode node = queue.remove();
            numLastLevel--;
            level.add(node.val);

            if (node.left != null) {
                queue.add(node.left);
                numCurLevel++;
            }
            if (node.right != null) {
                queue.add(node.right);
                numCurLevel++;
            }

            // 注意，这个一定要写在插入队列的后面
            // 因为，要把上一行的子节点全部插在queue中，
            // 然后算出这一行的节点数
            if (numLastLevel == 0) {
                levelOrder.add(level);
                numLastLevel = numCurLevel;
                numCurLevel = 0;
                level = new ArrayList<Integer>();
            }
        }
        return levelOrder;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        List<List<Integer>> levelOrder = levelOrder(t1);
        int a = 0;
    }
}
