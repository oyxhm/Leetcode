/**
 * Created by yhf on 15/5/25.
 */

/*
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
*/

public class SearchInRotatedSortedArray2 {
    public static boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > nums[left]) {   // 注意等号不要漏
                if (nums[mid] > target && target >= nums[left]) {
                    // 0 1 2 4 5 6 7, 2
                    right = mid - 1;
                } else {
                    // mid > target, target < left     1 2 4 5 6 7 0, 0
                    // mid < target, target > left     0 1 2 4 5 6 7, 6
                    // mid < target, target < left     not exist
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[left]) {   // mid < left
                if (nums[mid] > target || target >= nums[left]) {
                    // mid < target, target > left     5 6 7 0 1 2 4, 6
                    // mid > target, target < left     7 0 1 2 4 5 6, 1
                    // mid > target, target > left     not exist
                    right = mid - 1;
                } else {
                    // mid < target, target < left     5 6 7 0 1 2 4, 1
                    left = mid + 1;
                }
            } else {
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 4, 5, 6, 7};
        for (int i = 0; i < nums.length; i++) {
            RotateArrayByK.rotateArrayByK(nums, 1);
            System.out.println(search(nums, 6));
        }
    }
}
