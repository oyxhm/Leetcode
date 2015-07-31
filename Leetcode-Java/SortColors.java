/**
 * Created by yhf on 15/5/22.
 */

/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the
colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/

public class SortColors {
    public static void sortColors(int[] nums) {
        // two-pass, counting sort
        /*int[] colors = new int[3];
        for (int num: nums) {
            colors[num]++;
        }
        for (int i = 0, idx = 0; i < colors.length; i++) {
            while (colors[i]-- > 0) {
                nums[idx++] = i;
            }
        }*/

        // one-pass
        int i0 = 0, i1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = 2;
                nums[i1++] = 1;
                nums[i0++] = 0;
            } else if (nums[i] == 1) {
                nums[i] = 2;
                nums[i1++] = 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 1, 2, 2, 1, 0, 2};
        sortColors(nums);
    }
}
