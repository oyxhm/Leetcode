"""
Given an integer, write a function to determine if it is a power of two.
"""


class Solution:
    # @param {integer} n
    # @return {boolean}
    def isPowerOfTwo(self, n):
        if n > 2 and n % 2 == 1 or n <= 0:
            return False
        if n == 1:
            return True
        return self.isPowerOfTwo(n / 2)


if __name__ == '__main__':
    s = Solution()
    print s.isPowerOfTwo(-16)
    # print s.isPowerOfTwo(1)
    # print s.isPowerOfTwo(2)
    # print s.isPowerOfTwo(3)
    # print s.isPowerOfTwo(4)
