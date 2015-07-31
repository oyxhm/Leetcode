"""
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
"""


class Solution:
    # @param {integer} n
    # @return {integer[][]}
    def generateMatrix(self, n):
        m = [[0] * n for _ in xrange(n)]
        num = 1
        for i in xrange(n / 2):
            m[i][i] = num
            row = i
            col = i + 1
            num += 1
            while not (col == i and row == i):
                m[row][col] = num
                num += 1
                if col == n - 1 - i and row != n - 1 - i:  # right side
                    row += 1
                elif row == n - 1 - i and col != i:        # bottom side
                    col -= 1
                elif col == i and row != i:                # left side
                    row -= 1
                else:                                      # top side
                    col += 1
            i += 1                                         # next layer
        if n % 2 == 1:
            m[n / 2][n / 2] = num
        return m


if __name__ == '__main__':
    print Solution().generateMatrix(3)