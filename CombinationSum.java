import java.util.*;

/**
 * Created by yhf on 15/5/22.
 */

/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7,
A solution set is:
[7]
[2, 2, 3]
*/

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> resSet = new HashSet<>();
        if (candidates == null) {
            return res;
        }
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0, cur, res, resSet);
        return res;
    }

    public static void dfs(int[] candidates, int target, int idx, int curSum, List<Integer> cur, List<List<Integer>> res, Set<List<Integer>> resSet) {
        if (curSum == target) {
            if (!resSet.contains(cur)) {
                List<Integer> l = new ArrayList<Integer>(cur);
                resSet.add(l);
                res.add(l);
            }
            return;
        }

        if (curSum > target) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            cur.add(candidates[i]);
            dfs(candidates, target, i, curSum + candidates[i], cur, res, resSet);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = combinationSum(new int[]{2, 3, 6, 7}, 7);
    }
}
