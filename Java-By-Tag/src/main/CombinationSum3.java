package src.main;

/**
 * Created by yhf on 10/11/15.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be
 * used and each combination should be a unique set of numbers.
 *
 * Ensure that numbers within the set are sorted in ascending order.
 *
 * Example 1:
 *
 * Input: k = 3, n = 7
 *
 * Output:
 *
 * [[1,2,4]]
 *
 * Example 2:
 *
 * Input: k = 3, n = 9
 *
 * Output:
 *
 * [[1,2,6], [1,3,5], [2,3,4]]
 */

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0 || n == 0) {
            return res;
        }
        combinationSum3(k, n, 1, 0, new ArrayList<>(), res);
        return res;
    }

    private void combinationSum3(int k, int n, int num, int curSum,
                                 List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == k) {
            if (curSum == n) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        if (num > 9 || curSum > n) {
            return;
        }
        combinationSum3(k, n, num + 1, curSum, cur, res);
        cur.add(num);
        combinationSum3(k, n, num + 1, curSum + num, cur, res);
        cur.remove(cur.size() - 1);
    }
}
