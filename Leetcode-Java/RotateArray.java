/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
*/

import java.util.*;

public class RotateArray {
    public static void rotateArray1(int[] nums, int k) {
        // O(n^2) runtime, O(1) space
        int len = nums.length;
        if (k == 0) {
            return;
        }
        k = k % len;
        for (int i = 1; i <= k; i++) {
            rotateByOne(nums);
        }
    }

    public static void rotateByOne(int[] nums) {
        // rotate array to the right by 1
        int len = nums.length;
        int last = nums[len-1];
        for (int i = len - 1; i > 0; i--) {
            nums[i] = nums[i-1];
        }
        nums[0] = last;
    }

    public static void rotateArray2(int[] nums, int k) {
        // O(n) runtime, O(n) space
        int len = nums.length;
        if (k == 0) {
            return;
        }
        k = k % len;
        List<Integer> l = new ArrayList<Integer>();
        for (Integer i : nums) {
            l.add(i);
        }
        for (Integer i : nums) {
            l.add(i);
        }
        for (int i = 0; i < len; i++) {
            nums[i] = l.get(i+len-k);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        rotateArray2(nums, 2);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
