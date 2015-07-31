import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yhf on 15/6/12.
 */

/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
*/

public class BinaryTreePostorderTraversal {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> cur = new ArrayList<>();
        postorderTraversal(root, cur);
        return cur;
    }

    private static void postorderTraversal(TreeNode root, List<Integer> cur) {
        // Recursive
        if (root != null) {
            postorderTraversal(root.left, cur);
            postorderTraversal(root.right, cur);
            cur.add(root.val);
        }
    }

    public static List<Integer> postorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        TreeNode prev = null;

        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (prev == null || prev.left == cur || prev.right == cur) {
                // go down the tree
                if (cur.left != null) {
                    stack.push(cur.left);
                } else if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    res.add(stack.pop().val);
                }
            } else if (prev == cur.left) {
                // go up from left child
                if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    res.add(stack.pop().val);
                }
            } else {
                // go up from right child
                res.add(stack.pop().val);
            }
            prev = cur;
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.right = n2;
        n2.left = n3;
        List<Integer> list = postorderTraversal2(n1);
    }
}
