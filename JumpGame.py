"""
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
"""


class Solution:
    # @param {integer[]} nums
    # @return {boolean}
    def canJump(self, nums):
        # Time Limit Exceeded
        can_jump = [False] * len(nums)
        can_jump[0] = True
        for i in xrange(len(nums) - 1):
            if not can_jump[i]:
                return False
            for j in xrange(i, i + nums[i] + 1):
                if j >= len(nums):
                    return True
                can_jump[j] = True
        return can_jump[len(nums) - 1]

    def canJump2(self, nums):
        global_max = nums[0]
        for i in xrange(1, len(nums)):
            if i > global_max:
                return False
            local_max = nums[i] + i
            global_max = max(local_max, global_max)
            if global_max >= len(nums) - 1:
                return True
        return global_max >= len(nums) - 1


if __name__ == '__main__':
    print Solution().canJump2([2, 3, 1, 1, 4])
    print Solution().canJump2([3, 2, 1, 0, 4])
