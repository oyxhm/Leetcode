import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yhf on 15/4/19.
 */

/*
Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

// reference: http://blog.csdn.net/u011095253/article/details/9158397
//            http://mattcb.blogspot.com/2012/11/subset-i-ii.html

public class Subsets {
    public static List<List<Integer>> subsets(int[] S) {
        // dfs
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(S);
        dfs(S, 0, temp, res);
        temp = new ArrayList<Integer>();
        res.add(temp);   // 最后还要加上空集
        return res;
    }

    public static void dfs(int[] S, int index, List<Integer> temp, List<List<Integer>> res) {
        for (int i = index; i <= S.length - 1; i++) {
            temp.add(S[i]);
            res.add(new ArrayList<Integer>(temp));
            dfs(S, i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }

    public static List<List<Integer>> subsets2(int[] S) {
        // bfs
        Arrays.sort(S);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int n : S) {
            List<List<Integer>> tempRes = new ArrayList<List<Integer>>(res);
            for (List<Integer> subset : tempRes) {
                List<Integer> tempSubset = new ArrayList<Integer>(subset);
                tempSubset.add(n);
                res.add(tempSubset);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] S = {1, 2, 3};
        List<List<Integer>> res = subsets2(S);
    }
}
