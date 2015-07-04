"""
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row
below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
"""


class Solution:
    # @param triangle, a list of lists of integers
    # @return an integer
    def minimumTotal(self, triangle):
        if len(triangle) == 0:
            return 0
        dp = list(triangle[-1])
        for row in triangle[-2::-1]:
            for idx, num in enumerate(row):
                dp[idx] = num + min(dp[idx], dp[idx+1])
        return dp[0]


if __name__ == '__main__':
    triangle = [[2], [3,4], [6,5,7], [4,1,8,3]]
    print Solution().minimumTotal(triangle)
