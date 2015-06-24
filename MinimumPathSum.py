"""
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum
of all numbers along its path.

Note: You can only move either down or right at any point in time.
"""
import copy


class Solution:
    # @param {integer[][]} grid
    # @return {integer}
    def minPathSum(self, grid):
        cur_min = copy.deepcopy(grid)
        for i in xrange(len(grid)):
            for j in xrange(len(grid[0])):
                if i == 0 and j == 0:
                    cur_min[i][j] = grid[i][j]
                elif i == 0:
                    cur_min[i][j] = cur_min[i][j-1] + grid[i][j]
                elif j == 0:
                    cur_min[i][j] = cur_min[i-1][j] + grid[i][j]
                else:
                    cur_min[i][j] = min(cur_min[i-1][j], cur_min[i][j-1]) + grid[i][j]
        return cur_min[len(grid) - 1][len(grid[0]) - 1]


if __name__ == '__main__':
    grid = [
        [1, 2, 3],
        [4, 5, 1],
        [9, 4, 3]
    ]
    print Solution().minPathSum(grid)