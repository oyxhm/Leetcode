# encoding: utf-8
"""
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
"""


class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def firstMissingPositive(self, nums):
        if not nums:
            return 1
        i = 0
        while i < len(nums):
            if nums[i] >= 0 and nums[i] < len(nums) and nums[i] != nums[nums[i]]:
                # 注意，这里不能直接 nums[i], nums[nums[i]]那样交换，会死循环
                idx = nums[i]
                nums[i], nums[idx] = nums[idx], nums[i]
            else:
                i += 1

        # 这里好好想想
        i = 1
        while i < len(nums) and nums[i] == i:
            i += 1
        if i < len(nums):
            return i
        return i + 1 if nums[0] == i else i


if __name__ == '__main__':
    print Solution().firstMissingPositive([1, 2, 0])
    print Solution().firstMissingPositive([3, 4, -1, 1])
    print Solution().firstMissingPositive([0])
    print Solution().firstMissingPositive([2, 2])
