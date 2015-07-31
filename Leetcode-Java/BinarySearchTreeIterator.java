import java.util.Stack;

/**
 * Created by yhf on 15/5/28.
 */

/*
Implement an iterator over a binary search tree (BST). Your iterator
will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h)
memory, where h is the height of the tree.
*/

class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode smallest = stack.pop();
        if (smallest.right != null) {
            TreeNode node = smallest.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return smallest.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

public class BinarySearchTreeIterator {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(100);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(50);
        TreeNode n8 = new TreeNode(30);
        TreeNode n9 = new TreeNode(29);
        TreeNode n10 = new TreeNode(51);
        TreeNode n11 = new TreeNode(52);
        TreeNode n12 = new TreeNode(101);

        n1.left = n2; n1.right = n12;
        n2.left = n3; n2.right = n7;
        n3.left = n4; n3.right = n5;
        n5.right = n6;
        n7.left = n8; n7.right = n10;
        n8.left = n9;
        n10.right = n11;

        BSTIterator bstIterator = new BSTIterator(n1);
        while (bstIterator.hasNext()) {
            System.out.println(bstIterator.next());
        }
    }
}
