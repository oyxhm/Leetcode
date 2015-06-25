"""
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
"""


class Solution:
    # @param {integer[][]} matrix
    # @return {void} Do not return anything, modify matrix in-place instead.
    def rotate(self, matrix):
        n = len(matrix)
        for i in xrange(n / 2):
            for j in xrange(i + 1, n - i):
                matrix[j][i], matrix[i][n-1-j], matrix[n-1-j][n-1-i], matrix[n-1-i][j] =\
                    matrix[n-1-i][j], matrix[j][i], matrix[i][n-1-j], matrix[n-1-j][n-1-i]


if __name__ == '__main__':
    matrix = [
        [1, 2, 3, 4, 5],
        [6, 7, 8, 9, 10],
        [11, 12, 13, 14, 15],
        [16, 17, 18, 19, 20],
        [21, 22, 23, 24, 25]
    ]
    Solution().rotate(matrix)
    print matrix
