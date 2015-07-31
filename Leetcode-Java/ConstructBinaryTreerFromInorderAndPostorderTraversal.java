import java.util.HashMap;
import java.util.Map;

/**
 * Created by yhf on 15/5/15.
 */

/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/

public class ConstructBinaryTreerFromInorderAndPostorderTraversal {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, map, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder, Map<Integer, Integer> map,
                                     int inIdxL, int inIdxR, int postIdxL, int postIdxR) {
        if (inIdxL == inIdxR) {
            return new TreeNode(inorder[inIdxL]);
        }
        if (inIdxL > inIdxR || inIdxR < 0) {
            return null;
        }
        int rootIdx = map.get(postorder[postIdxR]);
        TreeNode root = new TreeNode(postorder[postIdxR]);
        root.left = buildTree(inorder, postorder, map, inIdxL, rootIdx - 1, postIdxL, rootIdx - 1 - inIdxL + postIdxL);
        root.right = buildTree(inorder, postorder, map, rootIdx + 1, inIdxR, rootIdx - inIdxL + postIdxL, postIdxR - 1);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, new int[]{1, 3, 2, 4, 6, 8, 7, 5});
    }
}
