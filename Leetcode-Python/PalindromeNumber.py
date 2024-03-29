"""
Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the
reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
"""


class Solution:
    # @param {integer} x
    # @return {boolean}
    def isPalindrome(self, x):
        if x < 0:
            return False
        div = 1
        while x / div >= 10:
            div *= 10
        while x != 0:
            q = x / div
            r = x % 10
            if q != r:
                return False
            x = (x % div) / 10
            div /= 100
        return True


if __name__ == '__main__':
    print Solution().isPalindrome(1234321)