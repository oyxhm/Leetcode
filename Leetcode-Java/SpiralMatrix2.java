/**
 * Created by yhf on 15/5/24.
 */

/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

public class SpiralMatrix2 {
    public static int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int i = 0, j = 0, num = 1;

        while (n > 0) {
            if (n == 1) {
                nums[i][j] = num;
                return nums;
            }

            for (int k = 0; k < n - 1; k++) {
                nums[i][j++] = num++;
            }
            for (int k = 0; k < n - 1; k++) {
                nums[i++][j] = num++;
            }
            for (int k = 0; k < n - 1; k++) {
                nums[i][j--] = num++;
            }
            for (int k = 0; k < n - 1; k++) {
                nums[i--][j] = num++;
            }

            n -= 2;
            i++;
            j++;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[][] nums = generateMatrix(0);
    }
}
