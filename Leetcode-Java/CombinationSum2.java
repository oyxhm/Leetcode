import jdk.nashorn.internal.ir.IdentNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yhf on 15/5/22.
 */

/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8,
A solution set is:
[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]
*/

public class CombinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0, cur, res);
        return res;
    }

    public static void dfs(int[] candidates, int target, int idx, int curSum, List<Integer> cur, List<List<Integer>> res) {
        if (idx > candidates.length || curSum > target) { // 注意这里不要写>=，不然可能会把curSum==target的情况漏过去
            return;
        }
        if (curSum == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            cur.add(candidates[i]);
            dfs(candidates, target, i + 1, curSum + candidates[i], cur, res);
            cur.remove(cur.size() - 1);
            while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) { // 这里要想清楚。如果i不算，那么后面跟i相等的都不算。
                i++;
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }
}
