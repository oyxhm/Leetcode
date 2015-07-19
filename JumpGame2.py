"""
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

In fact, we only needs the number of jumps but not the path we jump. So that we can modify the code in Jump Game. We do
not update step when we find a further position that we can reach. We only update it when step getting to 0. It means we
can find the minimum number of jumps. In fact, in the test cases of this problem we can always reach the end. If we need
to output -1 if we cannot reach the end, the code should be modified a little.
"""


class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def jump(self, nums):
        if len(nums) <= 1:
            return 0
        steps, max_reach, jumps = nums[0], nums[0], 1
        for idx, num in enumerate(nums[1:-1]):
            steps -= 1
            max_reach = max(max_reach, idx + 1 + num)
            if steps == 0:
                jumps += 1
                steps = max_reach - (idx + 1)
        return jumps


if __name__ == '__main__':
    print Solution().jump([2, 3, 1, 1, 4])
