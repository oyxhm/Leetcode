"""
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
"""


class Solution:
    # @param {integer} rowIndex
    # @return {integer[]}
    def getRow(self, rowIndex):
        pre = [1]
        if rowIndex == 0:
            return pre
        for row in xrange(1, rowIndex + 1):
            cur = [1] * (row + 1)
            for i in xrange(1, row / 2 + 1):
                cur[i] = pre[i - 1] + pre[i]
            for i in xrange(row / 2 + 1, row + 1):
                cur[i] = cur[row - i]
            pre = cur
        return pre


if __name__ == '__main__':
    print Solution().getRow(3)
