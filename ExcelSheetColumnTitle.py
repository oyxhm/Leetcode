"""
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
"""


class Solution:
    # @param {integer} n
    # @return {string}
    def convertToTitle(self, n):
        chars = ['Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
                 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y']
        title = ""
        while n:
            idx, n = n % 26, n / 26
            if idx == 0:
                n -= 1
            title = chars[idx] + title
        return title


if __name__ == '__main__':
    print Solution().convertToTitle(27)
