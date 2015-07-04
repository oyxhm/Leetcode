"""
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
"""


class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {integer[]}
    def searchRange(self, nums, target):
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = left + (right - left) / 2
            if nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
            else:
                left = right = mid
                while left >= 0 and nums[left] == target:
                    left -= 1
                while right < len(nums) and nums[right] == target:
                    right += 1
                return [left + 1, right - 1]
        return [-1, -1]


if __name__ == '__main__':
    print Solution().searchRange([5, 7, 7, 8, 8, 10], 8)
