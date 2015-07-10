"""
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return
the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
"""


class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {integer}
    def threeSumClosest(self, nums, target):
        closet = 2 ** 31
        nums.sort()
        for i in xrange(len(nums) - 2):
            left = i + 1
            right = len(nums) - 1
            while left < right:
                sum = nums[i] + nums[left] + nums[right]
                if sum == target:
                    return sum
                closet = sum if abs(sum - target) < abs(closet - target) else closet
                if sum < target:
                    left += 1
                else:
                    right -= 1
        return closet


if __name__ == '__main__':
    print Solution().threeSumClosest([1,1,1,0], 10)
