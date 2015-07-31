"""
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
"""


class Solution:
    # @param {integer[]} nums
    # @param {integer} val
    # @return {integer}
    def removeElement(self, nums, val):
        end = len(nums) - 1
        for i in xrange(end + 1):
            if nums[i] == val:
                while nums[end] == val:
                    end -= 1
                    if i >= end:
                        return i
                nums[i], nums[end] = nums[end], nums[i]
        return end + 1

if __name__ == '__main__':
    s = Solution()
    assert s.removeElement([3, 3, 2], 3) == 1
    assert s.removeElement([2, 3, 2], 3) == 2
    assert s.removeElement([2, 3, 3], 3) == 1
    assert s.removeElement([2, 3, 3], 4) == 3
