/**
 * Created by yhf on 15/5/23.
 */

/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

public class SearchForARange {
    public static int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
                right = mid;
                while (left >= 0 && nums[left] == target) {
                    left--;
                }
                while (right <= nums.length - 1 && nums[right] == target) {
                    right++;
                }
                return new int[]{left+1, right-1};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] res = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }
}
