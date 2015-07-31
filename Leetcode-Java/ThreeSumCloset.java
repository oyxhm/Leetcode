import java.util.Arrays;

/**
 * Created by yhf on 15/4/26.
 */

/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
Return the sum of the three integers. You may assume that each input would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

public class ThreeSumCloset {
    public static int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int minDist = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < len - 1; i++) {
            for (int left = i + 1, right = len - 1; left < right; ) {
                int dist = nums[i] + nums[left] + nums[right] - target;
                if (dist == 0) {
                    return target;
                } else {
                    minDist = Math.abs(dist) > Math.abs(minDist) ? minDist : dist;
                    if (dist < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return minDist + target;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8, 16, 32, 64, 128};
        System.out.println(threeSumClosest(nums, 82));
    }
}
