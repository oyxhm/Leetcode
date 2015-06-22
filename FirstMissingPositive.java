/**
 * Created by yhf on 15/6/22.
 */

/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        if (max <= 0) {
            return 1;
        }
        boolean[] record = new boolean[max + 1];
        for (int num : nums) {
            if (num > 0) {
                record[num] = true;
            }
        }
        for (int i = 1; i <= max; i++) {
            if (!record[i]) {
                return i;
            }
        }
        return max + 1;
    }

    public static void main(String[] args) {
        assert firstMissingPositive(new int[]{1, 2, 0}) == 3;
        assert firstMissingPositive(new int[]{3, 4, -1, 1}) == 2;
    }
}
