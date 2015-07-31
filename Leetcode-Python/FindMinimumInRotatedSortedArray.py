"""
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
"""


class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def findMin(self, nums):
        left = 0
        right = len(nums) - 1
        min_num = 2 ** 31
        while left <= right:
            mid = left + (right - left) / 2
            min_num = min(nums[mid], min_num)
            if (nums[mid]) > nums[right]:
                left = mid + 1
            else:
                right = mid - 1
        return min_num


if __name__ == '__main__':
    print Solution().findMin([3, 1, 2])
