package src.main;

/**
 * Created by yhf on 10/11/15.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 *
 * Note:
 *
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 *
 * If nums = [1,2,3], a solution is:
 *
 * [
 *  [3],
 *  [1],
 *  [2],
 *  [1,2,3],
 *  [1,3],
 *  [2,3],
 *  [1,2],
 *  []
 * ]
 */

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void subsets(int[] nums, int index, List<Integer> cur, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        cur.add(nums[index]);
        subsets(nums, index + 1, cur, res);
        cur.remove(cur.size() - 1);
        subsets(nums, index + 1, cur, res);
    }
}
