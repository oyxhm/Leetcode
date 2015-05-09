import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhf on 15/5/9.
 */

/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum
equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
*/

public class PathSumII {
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curPath = new ArrayList<Integer>();
        dfs(root, sum, 0, curPath, res);
        return res;
    }

    public static void dfs(TreeNode root, int sum, int curSum, List<Integer> curPath, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        curPath.add(root.val);
        curSum += root.val;
        if (root.left == null && root.right == null) {
            if (sum == curSum) {
                res.add(new ArrayList<Integer>(curPath));
            }
            return;
        }
        dfs(root.left, sum, curSum, new ArrayList<Integer>(curPath), res); // 注意这里，要么new一个，要么回溯
        dfs(root.right, sum, curSum, new ArrayList<Integer>(curPath), res);
    }

    public static void main(String[] args) {
        /*
        *     5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
        *
        * */
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(5);
        TreeNode n10 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n4.left = n7;
        n4.right = n8;
        n3.left = n5;
        n3.right = n6;
        n6.left = n9;
        n6.right = n10;
        List<List<Integer>> res = pathSum(n1, 22);
    }
}
