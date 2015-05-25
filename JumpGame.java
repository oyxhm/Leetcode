/**
 * Created by yhf on 15/5/25.
 */

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.   注意是maximum jump

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/

public class JumpGame {
    public static boolean canJump(int[] nums) {
        int[] max = new int[nums.length];
        int localMax = nums[0], globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > globalMax) {
                return false;
            }
            localMax = i + nums[i];
            globalMax = Math.max(localMax, globalMax);
            if (globalMax >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{1, 2}));
    }
}
