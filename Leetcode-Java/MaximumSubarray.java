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

    public static void main(String[] args) {
        int max = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }
}
