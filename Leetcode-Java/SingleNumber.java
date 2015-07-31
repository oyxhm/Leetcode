/**
 * Created by yhf on 15/4/20.
 */

/*
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

public class SingleNumber {
    public static int singleNumber(int[] A) {
        int res = 0;
        for (int num : A) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 2, 2, 3};
        System.out.println(singleNumber(A));
    }
}
