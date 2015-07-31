/**
 * Created by yhf on 15/5/27.
 */

/*
Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will
not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house
is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount
of money you can rob tonight without alerting the police.
*/

public class HouseRobber2 {
    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (nums.length == 3) {
            return Math.max(Math.max(nums[0], nums[2]), nums[1]);
        }
        // first time, omit the last one
        int even = nums[0];
        int odd = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            if (i % 2 == 0) {
                even = Math.max(even + nums[i], odd);
            } else {
                odd = Math.max(odd + nums[i], even);
            }
        }
        int max1 = Math.max(even, odd);

        // second time, omit the first one
        odd = nums[1];
        even = Math.max(nums[1], nums[2]);
        for (int i = 3; i < nums.length; i++) {
            if (i % 2 == 0) {
                even = Math.max(even + nums[i], odd);
            } else {
                odd = Math.max(odd + nums[i], even);
            }
        }
        int max2 = Math.max(even, odd);
        return Math.max(max1, max2);
    }

    public static void main(String[] args) {
        int i = rob(new int[]{1, 1, 2, 1});
    }
}
