"""
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
"""


class Solution:
    # @param {integer} n
    # @return {string}
    def countAndSay(self, n):
        s = "1"
        for _ in xrange(n - 1):
            i = 0
            new_s = ""
            while i < len(s):
                j = i
                while j < len(s) - 1 and s[j] == s[j+1]:
                    j += 1
                count = j - i + 1
                new_s += str(count) + s[j]
                i = j + 1
            s = new_s
        return s


if __name__ == '__main__':
    print Solution().countAndSay(1)
