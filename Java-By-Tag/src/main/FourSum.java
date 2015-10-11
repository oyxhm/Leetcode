package src.main;

/**
 * Created by yhf on 9/24/15.
 */

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all
 * unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 *
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 */

public class FourSum {
    // Two pointers, O(n^3)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        Set<List<Integer>> res = new HashSet<>();
        int len = nums.length;

        for (int i = 0; i < len - 3; i++) {
            for (int j = i + 1; j < len - 2; j++) {
                int left = j + 1, right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        List<Integer> tuple = new ArrayList<>();
                        tuple.add(nums[i]);
                        tuple.add(nums[j]);
                        tuple.add(nums[left]);
                        tuple.add(nums[right]);
                        res.add(tuple);
                        left++;
                        right--;
                    }
                }
            }
        }

        return new ArrayList<>(res);
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        // Hash,
        return null;
    }
}
