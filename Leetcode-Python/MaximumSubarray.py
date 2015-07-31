# encoding: utf-8
"""
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is
more subtle.
"""


class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def maxSubArray(self, nums):
        if not nums:
            return 0
        local_max = nums[0]
        global_max = nums[0]
        for num in nums[1:]:
            local_max = max(num, local_max + num)
            global_max = max(global_max, local_max)
        return global_max


if __name__ == '__main__':
    print Solution().maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4])