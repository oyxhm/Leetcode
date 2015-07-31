"""
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it
will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
money you can rob tonight without alerting the police.
"""


class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def rob(self, nums):
        if len(nums) == 0:
            return 0
        even = nums[0]
        if len(nums) == 1:
            return nums[0]
        odd = max(nums[0], nums[1])
        for i in xrange(2, len(nums)):
            if i % 2 == 0:
                even = max(even + nums[i], odd)
            else:
                odd = max(odd + nums[i], even)
        return max(even, odd)
