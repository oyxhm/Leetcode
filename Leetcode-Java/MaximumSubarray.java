/**
 * Created by yhf on 15/5/24.
 */

/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

与这题相似： https://leetcode.com/problems/maximum-product-subarray/

讲解看这里: http://blog.csdn.net/linhuanmars/article/details/21314059
          http://www.programcreek.com/2013/02/leetcode-maximum-subarray-java/

*/

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int localMax = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            localMax = Math.max(nums[i], localMax + nums[i]);
            globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;
    }


    /* divide and conquer
     * 1. If the maximum subarray is in the left half or in the right half, return the maximum subarray of the left half
     *    or the right half.
     * 2. If the maximum subarray crosses the mid element, then the maximum subarray is the maximum suffix of the left
     *    half plus the maximum prefix of the right half.
     */
    public static int maxSubArray2(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }

    private static int maxSubArray(int[] nums, int left, int right) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        int maxLeft = maxSubArray(nums, left, mid);
        int maxRight = maxSubArray(nums, mid + 1, right);

        int leftMax = nums[mid];
        int leftSum = 0;
        for (int i = mid; i >= left; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftSum, leftMax);
        }

        int rightMax = nums[mid + 1];
        int rightSum = 0;
        for (int i = mid + 1; i <= right; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightSum, rightMax);
        }

        int maxAcrossMid = leftMax + rightMax;
        return Math.max(Math.max(maxLeft, maxRight), maxAcrossMid);
    }

    public static void main(String[] args) {
        int max = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }
}
