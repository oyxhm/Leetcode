package src.main;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhf on 8/23/15.
 */

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 *
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */

public class UniqueBinarySearchTrees2 {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int left, int right) {
        List<TreeNode> roots = new ArrayList<>();
        if (left > right) {
            roots.add(null);
            return roots;
        }
        for (int i = left; i <= right; i++) {
            for (TreeNode leftChild : generateTrees(left, i - 1)) {
                for (TreeNode rightChild : generateTrees(i + 1, right)) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftChild;
                    root.right = rightChild;
                    roots.add(root);
                }
            }
        }
        return roots;
    }
}
