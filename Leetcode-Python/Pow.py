"""
Implement pow(x, n).
"""


class Solution:
    # @param {float} x
    # @param {integer} n
    # @return {float}
    def myPow(self, x, n):
        if n < 0:
            return 1 / self.myPow(x, -n)
        if n == 0:
            return 1
        temp = self.myPow(x, n / 2)
        return temp * temp if n % 2 == 0 else temp * temp * x
