"""
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
"""


class Solution:
    # @param {integer[][]} matrix
    # @return {void} Do not return anything, modify matrix in-place instead.
    def setZeroes(self, matrix):
        m = len(matrix)
        n = len(matrix[0])
        first_row_set_0 = first_col_set_0 = False
        if 0 in matrix[0]:
            first_row_set_0 = True
        for row in xrange(m):
            if matrix[row][0] == 0:
                first_col_set_0 = True
                break

        for row in xrange(1, m):
            if 0 in matrix[row]:
                matrix[row][0] = 0
        for col in xrange(1, n):
            for row in xrange(m):
                if matrix[row][col] == 0:
                    matrix[0][col] = 0
                    break

        for col in xrange(1, n):
            if matrix[0][col] == 0:
                for row in xrange(m):
                    matrix[row][col] = 0
        for row in xrange(1, m):
            if matrix[row][0] == 0:
                for col in xrange(n):
                    matrix[row][col] = 0
        if first_col_set_0:
            for row in xrange(m):
                matrix[row][0] = 0
        if first_row_set_0:
            matrix[0] = [0] * n


if __name__ == '__main__':
    matrix = [[1,2,3,4],[5,0,5,2],[8,9,2,0],[5,7,2,1]]
    Solution().setZeroes(matrix)
