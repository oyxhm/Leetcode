/**
 * Created by yhf on 15/5/22.
 */

/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
*/

public class UniquePaths2 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int lenX = obstacleGrid.length;
        if (lenX == 0) {
            return 0;
        }
        int lenY = obstacleGrid[0].length;
        if (lenY == 0) {
            return 0;
        }
        int[][] nums = new int[lenX][lenY];
        for (int i = 0; i < lenX; i++) {
            if (obstacleGrid[i][0] != 1) {
                nums[i][0] = 1;
            } else {
                break;
            }
        }
        for (int j = 0; j < lenY; j++) {
            if (obstacleGrid[0][j] != 1) {
                nums[0][j] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < lenX; i++) {
            for (int j = 1; j < lenY; j++) {
                if (obstacleGrid[i][j] == 0) {
                    nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
                }
            }
        }

        return nums[lenX - 1][lenY - 1];
    }

    public static void main(String[] args) {
        int count = uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
    }
}
