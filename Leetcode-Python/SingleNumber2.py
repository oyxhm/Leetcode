# encoding: utf-8
"""
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
"""


class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def singleNumber(self, nums):
        # 负数溢出
        digits = [0] * 32
        for num in nums:
             for i in xrange(32):
                 digits[i] += 1 & (num >> i)

        num = 0
        base = 1
        for times in digits:
            if times % 3:
                num += base
            base *= 2
        return num

    def singleNumber2(self, nums):
        one = two = three = 0
        for i in range(len(nums)):
            two |= nums[i] & one
            one = nums[i] ^ one
            three = ~(one & two)
            one &= three
            two &= three
        return one

    def singleNumber3(self, nums):
        digits = [0] * 32
        num_neg = 0
        for num in nums:
             if num < 0:
                 num = -num
                 num_neg += 1
             for i in xrange(32):
                 digits[i] += 1 & (num >> i)

        num = 0
        base = 1
        for times in digits:
            if times % 3:
                num += base
            base *= 2
        return num if num_neg % 3 == 0 else -num


if __name__ == '__main__':
    print Solution().singleNumber3([-2,-2,1,1,-3,1,-3,-3,-4,-2])