/**
 * Created by yhf on 15/5/21.
 */


/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.
*/

public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        int nums[][] = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            nums[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            nums[0][j] = 0;
        }
        nums[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
            }
        }
        return nums[m][n];
    }

    public static void main(String[] args) {
        int count = uniquePaths(3, 7);
    }
}
