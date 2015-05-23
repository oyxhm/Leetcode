import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhf on 15/5/23.
 */

/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        combine(n, k, 1, cur, res);
        return res;
    }

    private static void combine(int n, int k, int idx, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if (idx > n) {
            return;
        }

        combine(n, k, idx + 1, cur, res);
        cur.add(idx);
        combine(n, k, idx + 1, cur, res);
        cur.remove(cur.size() - 1);
    }

    public static void main(String[] args) {
        List<List<Integer>> res = combine(4, 2);
    }
}
