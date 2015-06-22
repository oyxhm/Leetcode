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
    def __init__(self):
        self.__res = dict()
        self.__res[0] = 1
        self.__res[1] = 1
        self.__res[2] = 2

    def numTrees(self, n):
        count = 0
        for i in xrange(1, n + 1):
            try:
                x = self.__res[i - 1]
            except KeyError:
                x = self.numTrees(i - 1)
                self.__res[i - 1] = x
            try:
                y = self.__res[n - i]
            except KeyError:
                y = self.numTrees(n - i)
                self.__res[n - i] = y
            count += x * y
        return count


if __name__ == '__main__':
    s = Solution()
    assert Solution().numTrees(3) == 5
    assert s.numTrees(19) == 1767263190