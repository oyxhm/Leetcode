"""
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of
1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
"""


class Solution:
    # @param {integer} x
    # @return {integer}
    def reverse(self, x):
        if (x < 0):
            return -1 * self.reverse(-x)
        result = x % 10
        rest = x / 10
        limit = 2147483647 / 10
        while rest > 0:
            if result > limit:
                return 0
            result *= 10
            result += rest % 10
            rest /= 10
        return result


if __name__ == '__main__':
    s = Solution()
    print s.reverse(123)
    print s.reverse(-123)
    print s.reverse(-2147483412)
