/**
 * Created by yhf on 15/5/20.
 */

/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
It doesn't matter what you leave beyond the new length.
*/

public class RemoveDuplicatesFromSortedArray2 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int prev = 1, curr = 2;
        while (curr < nums.length) {
            if (nums[prev] == nums[curr] && nums[prev - 1] == nums[curr]) {
                curr++;
            } else {
                prev++;
                nums[prev] = nums[curr];
                curr++;
            }
        }
        return prev + 1;
    }

    public static void main(String[] args) {
        int len = removeDuplicates(new int[]{1, 1, 2});
    }
}
