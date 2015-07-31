import java.util.HashMap;
import java.util.Map;

/**
 * Created by yhf on 15/5/15.
 */

/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, map, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder, Map<Integer, Integer> map,
                            int preL, int preR, int inL, int inR) {
        if (inR >= inorder.length || inL > inR) {
            return null;
        }
        if (inL == inR) {
            return new TreeNode(inorder[inL]);
        }
        int rootIdx = map.get(preorder[preL]);  // index of root in inorder
        TreeNode root = new TreeNode(preorder[preL]);
        root.left = buildTree(preorder, inorder, map, preL + 1, rootIdx - inL + preL, inL, rootIdx - 1);
        root.right = buildTree(preorder, inorder, map, rootIdx - inL + preL + 1, preR, rootIdx + 1, inR);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree(new int[]{5, 4, 2, 1, 3, 7, 6, 8}, new int[]{1, 2, 3, 4, 5, 6, 7, 8});
    }
}
