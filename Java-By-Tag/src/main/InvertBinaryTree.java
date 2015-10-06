package src.main;

/**
 * Created by yhf on 10/6/15.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Invert a binary tree.
 */

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        // DFS
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }

    public TreeNode invertTreeBFS(TreeNode root) {
        // BFS
        if (root == null) {
            return root;
        }
        List<TreeNode> q = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                size--;
                TreeNode node = q.remove(0);
                if (node != null) {
                    TreeNode temp = node.left;
                    node.left = node.right;
                    node.right = temp;
                    q.add(node.right);
                    q.add(node.left);
                }
            }
        }
        return root;
    }
}
