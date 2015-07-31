"""
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with
the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's
and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
"""


class Solution:
    # @param {integer[]} nums
    # @return {void} Do not return anything, modify nums in-place instead.
    def sortColors(self, nums):
        num_red = nums.count(0)
        num_white = nums.count(1)
        for i in xrange(num_red):
            nums[i] = 0
        for i in xrange(num_red, num_red + num_white):
            nums[i] = 1
        for i in xrange(num_red + num_white, len(nums)):
            nums[i] = 2

    def sortColors2(self, nums):
        # one pass
        i0 = i1 = 0
        for i in xrange(len(nums)):
            if nums[i] == 0:
                nums[i] = 2
                nums[i1] = 1
                i1 += 1
                nums[i0] = 0
                i0 += 1
            elif nums[i] == 1:
                nums[i] = 2
                nums[i1] = 1
                i1 += 1


if __name__ == '__main__':
    nums = [1, 1, 0, 0, 1, 1, 2, 0, 1, 2, 2]
    Solution().sortColors2(nums)
    print nums

