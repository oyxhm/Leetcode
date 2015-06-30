"""
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
"""


class Solution:
    # @param {integer[][]} obstacleGrid
    # @return {integer}
    def uniquePathsWithObstacles(self, obstacleGrid):
        num_rows = len(obstacleGrid)
        num_cols = len(obstacleGrid[0])
        if 0 in (num_rows, num_cols):
            return 0
        dp = [[0 for _ in xrange(num_cols)] for _ in xrange(num_rows)]
        for col in xrange(num_cols):
            if obstacleGrid[0][col] == 0:
                dp[0][col] = 1
            else:
                break
        for row in xrange(num_rows):
            if obstacleGrid[row][0] == 0:
                dp[row][0] = 1
            else:
                break
        for row in xrange(1, num_rows):
            for col in xrange(1, num_cols):
                dp[row][col] = 0 if obstacleGrid[row][col] == 1 else dp[row-1][col] + dp[row][col-1]
        return dp[num_rows-1][num_cols-1]

if __name__ == '__main__':
    obstacleGrid = [
        [0,0,0],
        [0,1,0],
        [0,0,0]
    ]
    print Solution().uniquePathsWithObstacles(obstacleGrid)