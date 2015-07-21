"""
Implement int sqrt(int x).

Compute and return the square root of x.
"""


class Solution:
    # @param {integer} x
    # @return {integer}
    def mySqrt(self, x):
        left, right = 0, x
        while left < right:
            mid = left + (right - left) / 2
            if mid ** 2 == x or mid ** 2 < x and (mid + 1) ** 2 > x:
                return mid
            if mid ** 2 > x:
                right = mid - 1
            else:
                left = mid + 1
        return left


if __name__ == '__main__':
    s = Solution()
    print map(s.mySqrt, range(10))
