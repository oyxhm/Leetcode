import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhf on 15/5/25.
 */

/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/

public class CombinationSum3 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n <= 0) {
            return res;
        }
        combination(k, n, 1, 0, cur, res);
        return res;
    }

    private static void combination(int k, int n, int idx, int curSum, List<Integer> cur, List<List<Integer>> res) {
        if (curSum == n && cur.size() == k) {        // 两段的位置不要写反。写反的话下一段就要写 idx > 10
            List<Integer> l = new ArrayList<>(cur);
            res.add(l);
            return;
        }

        if (idx > 9 || curSum > n || cur.size() > k) {
            return;
        }

        combination(k, n, idx + 1, curSum, cur, res);
        cur.add(idx);
        combination(k, n, idx + 1, curSum + idx, cur, res);
        cur.remove(cur.size() - 1);
    }

    public static void main(String[] args) {
        List<List<Integer>> res = combinationSum3(3, 15);
    }
}
