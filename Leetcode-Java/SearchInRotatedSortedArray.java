/**
 * Created by yhf on 15/5/25.
 */

/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        // 要比较 left, mid, target 三者的关系
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[left]) {   // 注意等号不要漏
                if (nums[mid] > target && target >= nums[left]) {
                    // 0 1 2 4 5 6 7, 2
                    right = mid - 1;
                } else {
                    // mid > target, target < left     1 2 4 5 6 7 0, 0
                    // mid < target, target > left     0 1 2 4 5 6 7, 6
                    // mid < target, target < left     not exist
                    left = mid + 1;
                }
            } else {   // mid < left
                if (nums[mid] > target || target >= nums[left]) {
                    // mid < target, target > left     5 6 7 0 1 2 4, 6
                    // mid > target, target < left     7 0 1 2 4 5 6, 1
                    // mid > target, target > left     not exist
                    right = mid - 1;
                } else {
                    // mid < target, target < left     5 6 7 0 1 2 4, 1
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 4, 5, 6, 7};
        for (int i = 0; i < nums.length; i++) {
            RotateArrayByK.rotateArrayByK(nums, 1);
            System.out.println(search(nums, 6));
        }
    }
}
