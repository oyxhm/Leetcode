"""
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter
what you leave beyond the new length.
"""


class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def removeDuplicates(self, nums):
        if len(nums) <= 2:
            return len(nums)
        i = 0
        j = 1
        while j < len(nums):
            if nums[j] != nums[i] or (nums[j] == nums[i] and (i == 0 or nums[i] != nums[i - 1])):
                i += 1
                nums[i] = nums[j]
            j += 1
        return i + 1


if __name__ == '__main__':
    print Solution().removeDuplicates([1,1,1])
