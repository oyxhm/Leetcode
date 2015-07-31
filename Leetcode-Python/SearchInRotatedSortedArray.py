"""
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.


5 6 7  3 4

You may assume no duplicate exists in the array.
"""


class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {integer}
    def search(self, nums, target):
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = left + (right - left) / 2
            if nums[mid] == target:
                return mid
            # NOTE: < and <=
            if nums[mid] <= nums[right]: # the right half is sorted
                if nums[mid] < target <= nums[right]:
                    left = mid + 1  # search in the right half
                else:
                    right = mid - 1
            else:  # the left half is sorted
                if nums[left] <= target < nums[mid]: # search in the left half
                    right = mid - 1
                else:
                    left = mid + 1
        return -1


if __name__ == '__main__':
    nums = [1, 2, 3, 4, 5, 6, 7]
    for _ in xrange(8):
        print Solution().search(nums, 1)
        nums = nums[1:] + [nums[0]]
