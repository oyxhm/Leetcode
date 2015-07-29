"""
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
"""


class Solution:
    # @param {character[][]} matrix
    # @return {integer}
    def maximalSquare(self, matrix):
        if not matrix or not matrix[0]:
            return 0
        m, n = len(matrix), len(matrix[0])
        max_square = [[0] * n for _ in xrange(m)]
        for i in xrange(m):
            max_square[i][0] = int(matrix[i][0])
        for j in xrange(n):
            max_square[0][j] = int(matrix[0][j])

        for i in xrange(1, m):
            for j in xrange(1, n):
                if matrix[i][j] == '1':
                    max_square[i][j] = min(max_square[i-1][j-1], max_square[i][j-1], max_square[i-1][j]) + 1

        return max([max(row) for row in max_square]) ** 2
