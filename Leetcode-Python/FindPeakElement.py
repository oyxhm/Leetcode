# encoding: utf-8
"""
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

Note:
Your solution should be in logarithmic complexity.
"""


class Solution:
    # @param nums, an integer[]
    # @return an integer
    def findPeakElement(self, nums):
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = left + (right - left)
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == right or nums[mid] > nums[mid + 1]):
                return mid
            elif mid > 0 and nums[mid] < nums[mid - 1]:
                right = mid - 1
            else:
                left = mid + 1
        return mid
