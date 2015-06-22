# encoding: utf-8
"""
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it
would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
"""


class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {integer}
    def searchInsert(self, nums, target):
        for idx, num in enumerate(nums):
            if num >= target:
                return idx
        return len(nums)


if __name__ == '__main__':
    s = Solution()
    print s.searchInsert([1, 3, 5, 6], 5)
    print s.searchInsert([1, 3, 5, 6], 2)
    print s.searchInsert([1, 3, 5, 6], 7)
    print s.searchInsert([1, 3, 5, 6], 0)
    print s.searchInsert([], 2)
