/**
 * Created by yhf on 15/4/20.
 */

/*
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

public class SingleNumber2 {
    public static int singleNumber(int[] A) {
        int[] count = new int[32];
        for (int num : A) {
            int i = 0;
            while (i <= 31) {
                count[i] += (num >> i) & 1;
                i++;
            }
        }
        int base = 1, sum = 0;
        for (int n : count) {
            if (n % 3 != 0) {
                sum += base;
            }
            base *= 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 1, 2, 3, 3, 3, 2, 4, 2};
        System.out.println(singleNumber(A));
    }
}
