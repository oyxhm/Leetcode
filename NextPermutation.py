# encoding: utf-8
"""
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

0) Initialize partition_idx = change_idx = -1
1) From right to left, find the first number that violate the ascending trend, called partition_idx
2) if partition_idx exists, from right to left, find the first number greater than nums[partition_idx],
   called change_idx
3) If change_idx, then swap nums[partition_idx], nums[change_idx]
4) Reverse the list on the right of partition_idx (does not include partition_idx)
"""


class Solution:
    # @param {integer[]} nums
    # @return {void} Do not return anything, modify nums in-place instead.
    def nextPermutation(self, nums):
        partition_idx = change_idx = -1
        for idx in xrange(len(nums) - 2, -1, -1):
            if nums[idx] < nums[idx+1]:
                partition_idx = idx
                break

        if partition_idx != -1:
            for idx in xrange(len(nums) - 1, -1, -1):
                if nums[idx] > nums[partition_idx]:
                    change_idx = idx
                    break

        if -1 not in (partition_idx, change_idx):
            nums[partition_idx], nums[change_idx] = nums[change_idx], nums[partition_idx]

        i, j = partition_idx + 1, len(nums) - 1
        while i < j:
            nums[i], nums[j] = nums[j], nums[i]
            i += 1
            j -= 1


if __name__ == '__main__':
    nums = [1, 2, 3]
    Solution().nextPermutation(nums)
    print nums
