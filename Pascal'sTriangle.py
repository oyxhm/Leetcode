"""
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
"""


class Solution:
    # @param {integer} numRows
    # @return {integer[][]}
    def generate(self, numRows):
        res = []
        pre = [1]
        if numRows == 0:
            return res
        res.append(pre)
        for row in xrange(1, numRows):
            cur = [1] * (row + 1)
            for i in xrange(1, row / 2 + 1):
                cur[i] = pre[i - 1] + pre[i]
            for i in xrange(row / 2 + 1, row + 1):
                cur[i] = cur[row - i]
            res.append(list(cur))
            pre = cur
        return res


if __name__ == '__main__':
    print Solution().generate(5)

