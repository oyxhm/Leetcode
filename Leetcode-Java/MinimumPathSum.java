/**
 * Created by yhf on 8/5/15.
 */

/*
* Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum
* of all numbers along its path.
*
* Note: You can only move either down or right at any point in time.
*/

public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {1, 3, 2, 5},
                {2, 2, 1, 3},
                {3, 4, 8, 10},
                {5, 2, 3, 2}
        };
        System.out.println(minPathSum(grid));
    }
}
