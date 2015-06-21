"""
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
"""


class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def singleNumber(self, nums):
        return reduce(lambda x, y: x ^ y, nums)


if __name__ == '__main__':
    assert Solution().singleNumber([1, 3, 1, 2, 2]) == 3
