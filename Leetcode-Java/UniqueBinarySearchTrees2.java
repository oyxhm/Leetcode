import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhf on 15/5/16.
 */

/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

public class UniqueBinarySearchTrees2 {
    public static List<TreeNode> generateTrees(int n) {
        return generateTree(1, n);
    }

    public static List<TreeNode> generateTree(int left, int right) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (left > right) {
            res.add(null); // 注意，这里一定要加null. 不加null的话，下一递归中for循环会跳过去
            return res;
        }
        for (int i = left; i <= right; i++) {
            for (TreeNode leftNode : generateTree(left, i - 1)) {
                for (TreeNode rightNode : generateTree(i + 1, right)) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<TreeNode> res = generateTrees(3);
    }
}
