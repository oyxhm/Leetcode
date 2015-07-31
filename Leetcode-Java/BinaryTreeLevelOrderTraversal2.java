/**
 * Created by yhf on 15/4/17.
 */

/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
*/

import java.util.*;

public class BinaryTreeLevelOrderTraversal2 {
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

            if (numLastLevel == 0) {
                levelOrder.add(level);
                numLastLevel = numCurLevel;
                numCurLevel = 0;
                level = new ArrayList<Integer>();
            }
        }
        return levelOrder;
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrder = levelOrder(root),
                            levelOrderBottom = new ArrayList<List<Integer>>();
        int i = levelOrder.size() - 1;
        while (i >= 0) {
            levelOrderBottom.add(levelOrder.get(i--));
        }
        return levelOrderBottom;
    }
}
