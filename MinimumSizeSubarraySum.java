/**
 * Created by yhf on 15/5/12.
 */

/*
Given an array of n positive integers and a positive integer s, find the minimal length
of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
*/

public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        int min = Integer.MAX_VALUE, sum = 0;
        int left = 0, right = -1;
        while (left < right || right <= 0) {
            if (sum >= s) {
                min = Math.min(right - left + 1, min);
                sum -= nums[left];
                left++;
            } else if (right < len - 1) {
                right++;
                sum += nums[right];
            } else {
                break;
            }
        }
        if (min == Integer.MAX_VALUE) {
            return 0;
        }
        return nums[left] >= s ? 1 : min;
    }

    public static int minSubArrayLen2(int s, int[] nums) {
        int len = nums.length;
        int min = len + 1, left = 0, right = 0, sum = 0;
        while (right < len) {
            sum += nums[right];
            while (sum >= s) {
                if (right == left) {
                    return 1;
                }
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return min == len + 1 ? 0 : min;
    }

    public static void main(String[] args) {
        int min = minSubArrayLen2(100, new int[] {2, 3, 1, 2, 4, 8});
        int min2 = minSubArrayLen2(7, new int[] {2, 3, 1, 2, 4, 3});
        int min3 = minSubArrayLen2(7, new int[] {2, 3, 1, 2, 4, 8});
        int min4 = minSubArrayLen2(7, new int[]{2, 3, 2});
    }
}
