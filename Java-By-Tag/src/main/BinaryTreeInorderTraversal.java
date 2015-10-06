package src.main;

/**
 * Created by yhf on 10/6/15.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 *
 * return [1,3,2].
 */

public class BinaryTreeInorderTraversal {

    private List<Integer> traversal = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        // DFS
        if (root != null) {
            inorderTraversal(root.left);
            traversal.add(root.val);
            inorderTraversal(root.right);
        }
        return traversal;
    }

    public List<Integer> inorderTraversalBFS(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        if (root == null) {
            return traversal;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                traversal.add(node.val);
                root = node.right;
            }
        }
        return traversal;
    }
}
