"""
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.
"""


class Solution:
    # @param {integer} m
    # @param {integer} n
    # @return {integer}
    def rangeBitwiseAnd(self, m, n):
        # Time Limit Exceeded
        return reduce(lambda x, y: x & y, xrange(m, n+1))

    def rangeBitwiseAnd2(self, m, n):
        offset = 0
        while m != n:
            m >>= 1
            n >>= 1
            offset += 1
        return m << offset


if __name__ == '__main__':
    print Solution().rangeBitwiseAnd2(5, 7)
