#encoding: utf-8
"""
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
"""


class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {integer[][]}
    def fourSum(self, nums, target):
        nums.sort()
        res = set()

        for i in xrange(len(nums) - 3):
            for j in xrange(i+1, len(nums) - 2):
                sum_i_j = nums[i] + nums[j]
                left, right = j + 1, len(nums) - 1
                while left < right:
                    sum_four = sum_i_j + nums[left] + nums[right]
                    if sum_four == target:
                        res.add((nums[i], nums[j], nums[left], nums[right]))
                        left += 1
                        right -= 1
                    elif sum_four < target:
                        left += 1
                    else:
                        right -= 1
        return list(res)


if __name__ == '__main__':
    nums = [-3,-2,-1,0,0,1,2,3]
    print Solution().fourSum(nums, 0)
