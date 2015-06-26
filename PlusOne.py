"""
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
"""


class Solution:
    # @param {integer[]} digits
    # @return {integer[]}
    def plusOne(self, digits):
        carry = 0
        for i in xrange(len(digits) - 1, -1, -1):
            sum = digits[i] + 1 + carry if i == len(digits) - 1 else digits[i] + carry
            digits[i], carry = sum % 10, sum / 10
        if carry != 0:
            digits.insert(0, carry)
        return digits


if __name__ == '__main__':
    digits = [9, 9, 9]
    print Solution().plusOne(digits)
