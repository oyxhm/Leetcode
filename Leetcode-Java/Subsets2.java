import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by yhf on 15/5/18.
 */

/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

public class Subsets2 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> resSet = new HashSet<>();
        dfs(nums, 0, cur, res, resSet);
        return res;
    }

    public static void dfs(int[] nums, int index, List<Integer> cur, List<List<Integer>> res, Set<List<Integer>> resSet) {
        if (index == nums.length) {
            List l = new ArrayList<>(cur);
            if (!resSet.contains(l)) {
                resSet.add(l);
                res.add(l);
            }
            return;
        }
        cur.add(nums[index++]);
        dfs(nums, index, cur, res, resSet);
        cur.remove(cur.size() - 1);
        dfs(nums, index, cur, res, resSet);
    }

    public static void main(String[] args) {
        List<List<Integer>> res = subsetsWithDup(new int[]{1, 2, 2});
    }
}
