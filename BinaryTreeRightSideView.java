import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yhf on 15/5/1.
 */

/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
*/

public class BinaryTreeRightSideView {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<Integer>();
        if (root == null) {
            return view;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int curLevelSize = queue.size();
            for (int i = 0; i < curLevelSize; i++) {
                TreeNode node = queue.remove();
                if (i == 0) {
                    view.add(node.val);  // node on the right side
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
        }
        return view;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5);
        TreeNode t7 = new TreeNode(7);
        TreeNode t4 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.left = t6;
        t2.right = t5;
        t3.left = t7;
        t3.right = t4;
        List<Integer> view = rightSideView(t1);
    }
}
