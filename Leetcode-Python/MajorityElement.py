"""
Given an array of size n, find the majority element. The majority element is the element that appears more than [ n/2 ]
times.

You may assume that the array is non-empty and the majority element always exist in the array.
"""


class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def majorityElement(self, nums):
        return sorted(nums)[len(nums)/2]
