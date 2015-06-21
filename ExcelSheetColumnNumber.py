"""
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
"""


class Solution:
    # @param {string} s
    # @return {integer}
    def titleToNumber(self, s):
        l = len(s)
        num = 0
        base = 26 ** (l - 1)
        for i in xrange(l - 1, -1, -1):
            num += base * (ord(s[l - i - 1]) - ord('A') + 1)
            base /= 26
        return num


if __name__ == '__main__':
    s = Solution()
    assert s.titleToNumber('B') == 2
    assert s.titleToNumber('AB') == 28

