"""
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
"""


class Solution:
    # @param {integer[][]} matrix
    # @param {integer} target
    # @return {boolean}
    def searchMatrix(self, matrix, target):
        top = 0
        bottom = len(matrix) - 1
        while top <= bottom:
            mid = top + (bottom - top) / 2
            if matrix[mid][0] == target:
                return True
            if matrix[mid][0] < target:
                top = mid + 1
            else:
                bottom = mid -1
        line = matrix[top - 1]
        if line < 0:
            return False
        left = 0
        right = len(line) - 1
        while left <= right:
            mid = left + (right - left) / 2
            print mid
            if line[mid] == target:
                return True
            if line[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return False


if __name__ == '__main__':
    matrix = [
        [1,   3,  5,  7],
        [10, 11, 16, 20],
        [23, 30, 34, 50]
    ]
    print Solution().searchMatrix(matrix, 1)
    print Solution().searchMatrix(matrix, 2)
    print Solution().searchMatrix(matrix, 10)
    print Solution().searchMatrix(matrix, 11)
    print Solution().searchMatrix(matrix, 23)
    print Solution().searchMatrix(matrix, 24)
    print Solution().searchMatrix(matrix, 51)