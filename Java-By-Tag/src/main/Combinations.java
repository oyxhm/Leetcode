package src.main;

/**
 * Created by yhf on 10/11/15.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * For example,
 *
 * If n = 4 and k = 2, a solution is:
 *
 * [
 *  [2,4],
 *  [3,4],
 *  [2,3],
 *  [1,2],
 *  [1,3],
 *  [1,4],
 * ]
 */

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0) {
            return res;
        }
        combine(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    private void combine(int n, int k, int num, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == k) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        if (num > n) {
            return;
        }
        combine(n, k, num + 1, cur, res);
        cur.add(num);
        combine(n, k, num + 1, cur, res);
        cur.remove(cur.size() - 1);
    }
}
