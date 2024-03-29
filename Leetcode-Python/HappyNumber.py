"""
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by
the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops
endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

"""


class Solution:
    # @param {integer} n
    # @return {boolean}
    def isHappy(self, n):
        def sum_square(num):
            return sum(map(lambda n: int(n)**2, str(num)))

        s = set()
        while n not in s and n != 1:
            s.add(n)
            n = sum_square(n)
        return n == 1
