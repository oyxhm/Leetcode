"""
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
"""


class Solution:
    # @param {integer} n
    # @return {integer}
    def trailingZeroes(self, n):
        if n <= 4:
            return 0
        if n == 5:
            return 1
        return self.trailingZeroes(n/5) + n/5

    def trailingZeroes2(self, n):
        remainders = list()
        r = 0
        while n:
            n, r = n / 5, n % 5
            remainders.append(r)

        sum = count = 0
        for r in remainders:
            sum += r * count
            count = count * 5 + 1
        return sum


if __name__ == '__main__':
    print Solution().trailingZeroes(4)
