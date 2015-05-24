/**
 * Created by yhf on 15/5/24.
 */

/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.

与Maximum Subarray对照着做
*/

public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int localMax = nums[0];
        int localMin = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = localMax;
            localMax = Math.max(Math.max(nums[i], localMax * nums[i]), localMin * nums[i]);
            localMin = Math.min(Math.min(nums[i], localMin * nums[i]), temp * nums[i]);
            globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;
    }

    public static void main(String[] args) {
        int max = maxProduct(new int[]{2, 3, -2, 4});
    }
}
