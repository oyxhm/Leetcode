"""
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.


In Jump Game, we can save the farthest position we can reach when we go through the array.
Every time we move, we will decrease the step. When we updating it, the step remaining for
us is also updated. For example, for array A = [2, 3, 1, 1, 4], when we visit A[0], we update
the maxReach to 2, and step to 2. When we visit A[1], we update maxReach to 1 + 3 = 4. And step
is updated to 3. We will continue doing this until we reach the end or step getting to zero. If
step getting to zero before we reach the end, it means that we can’t move forward so that we
should return false.
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
