import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by yhf on 15/5/19.
 */

/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/

public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int low = 0, high = nums.length - 1, min = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            min = Math.min(min, nums[mid]);
        }
        return min;
    }

    public static void main(String[] args) {
        int min = findMin(new int[]{4, 5, 6, 0, 1, 2, 3});
    }
}
