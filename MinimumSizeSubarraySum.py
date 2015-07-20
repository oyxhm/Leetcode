# encoding: utf-8
"""
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s.
If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

More practice:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
"""


class Solution:
    # @param {integer} s
    # @param {integer[]} nums
    # @return {integer}
    def minSubArrayLen(self, s, nums):
        left = right = 0
        min_len = len(nums) + 1
        sum_ = 0
        while right < len(nums):
            sum_ += nums[right]
            while sum_ >= s:
                if left == right:
                    return 1
                min_len = min(min_len, right - left + 1)
                sum_ -= nums[left]
                left += 1
            right += 1
        return min_len if min_len < len(nums) + 1 else 0


if __name__ == '__main__':
    print Solution().minSubArrayLen(80, [10, 5, 13, 4, 8, 4, 5, 11, 14, 9, 16, 10, 20, 8])
