package src.main;

/**
 * Created by yhf on 8/22/15.
 */

/*
* Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
*
* For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
* the contiguous subarray [4,−1,2,1] has the largest sum = 6.
*
* More practice:
* If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is
* more subtle.
* */

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int local = nums[0], global = nums[0];
        for (int i = 1; i < nums.length; i++) {
            local = Math.max(local + nums[i], nums[i]);
            global = Math.max(global, local);
        }
        return global;
    }

    public int maxSubArray2(int[] nums) {
        // Divide and Conquer
        return maxSubArray(nums, 0, nums.length - 1);
    }

    private int maxSubArray(int[] nums, int left, int right) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;
        int leftMax = maxSubArray(nums, left, mid);
        int rightMax = maxSubArray(nums, mid + 1, right);

        int crossLeftSum = 0, crossLeftMax = nums[mid];
        for (int i = mid; i >= left; i--) {
            crossLeftSum += nums[i];
            crossLeftMax = Math.max(crossLeftMax, crossLeftSum);
        }

        int crossRightSum = 0, crossRightMax = nums[mid+1];
        for (int i = mid + 1; i <= right; i++) {
            crossRightSum += nums[i];
            crossRightMax = Math.max(crossRightMax, crossRightSum);
        }

        return Math.max(crossLeftMax + crossRightMax, Math.max(leftMax, rightMax));
    }
}
