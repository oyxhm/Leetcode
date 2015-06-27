"""
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
"""


class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def longestConsecutive(self, nums):
        s = set(nums)
        longest = 1
        for num in nums:
            left = num - 1
            right = num + 1
            while s.__contains__(left):
                s.remove(left)
                left -= 1
            while s.__contains__(right):
                s.remove(right)
                right += 1
            longest = max(longest, right - left - 1)
        return longest


if __name__ == '__main__':
    print Solution().longestConsecutive([-1, 1, 0])