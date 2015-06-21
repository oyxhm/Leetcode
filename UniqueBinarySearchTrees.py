"""
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
"""


class Solution:
    # @param {integer} n
    # @return {integer}
    def numTrees(self, n):
        if n == 0:
            return 1
        if n == 1 or n == 2:
            return n
        count = 0
        for i in xrange(1, n + 1):
            count += self.numTrees(i - 1) * self.numTrees(n - i)
        return count


if __name__ == '__main__':
    print Solution().numTrees(3)