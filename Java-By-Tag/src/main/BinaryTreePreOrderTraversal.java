package src.main;

/**
 * Created by yhf on 10/6/15.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 *
 * return [1,2,3].
 */

public class BinaryTreePreOrderTraversal {
    private List<Integer> traversal = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            traversal.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return traversal;
    }

    public List<Integer> preorderTraversalBFS(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        if (root == null) {
            return traversal;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            traversal.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return traversal;
    }
}
