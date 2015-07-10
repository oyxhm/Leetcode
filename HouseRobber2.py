"""
After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not
get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the
neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous
street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
money you can rob tonight without alerting the police.
"""


class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def rob(self, nums):
        if not nums:
            return 0
        if len(nums) <= 3:
            return max(nums)

        # first time, omit the last one
        even = nums[0]
        odd = max(nums[0], nums[1])
        for i in xrange(2, len(nums) - 1):
            if i % 2 == 0:
                even = max(odd, even + nums[i])
            else:
                odd = max(even, odd + nums[i])
        max1 = max(even, odd)

        # second time, omit the first one
        odd = nums[1]
        even = max(nums[1], nums[2])
        for i in xrange(3, len(nums)):
            if i % 2 == 0:
                even = max(odd, even + nums[i])
            else:
                odd = max(even, odd + nums[i])
        max2 = max(even, odd)

        return max(max1, max2)
