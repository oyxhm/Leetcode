"""
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
"""


class Solution:
    # @param {string} a
    # @param {string} b
    # @return {string}
    def addBinary(self, a, b):
        if not a or not b:
            return a or b
        a, b = a[::-1], b[::-1]
        res = ""
        carry = 0
        for i in xrange(min(len(a), len(b))):
            digit = int(a[i]) + int(b[i]) + carry
            carry = digit / 2
            res += str(digit % 2)
        for j in xrange(i + 1, len(a)):
            digit = int(a[j]) + carry
            carry = digit / 2
            res += str(digit % 2)
        for j in xrange(i + 1, len(b)):
            digit = int(b[j]) + carry
            carry = digit / 2
            res += str(digit % 2)
        if carry:
            res += str(carry)
        return res[::-1]

if __name__ == '__main__':
    print Solution().addBinary("111", "1")
