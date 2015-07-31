"""
Given an array of integers and an integer k, find out whether there there are two distinct indices i and j
in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
"""


class Solution:
    # @param {integer[]} nums
    # @param {integer} k
    # @return {boolean}
    def containsNearbyDuplicate(self, nums, k):
        # Time Limit Exceeded
        num_idx_map = dict()
        for idx, num in enumerate(nums):
            if num_idx_map.get(num) is not None:
                if idx - num_idx_map.get(num) <= k:
                    return True
            num_idx_map[num] = idx
        return False


if __name__ == '__main__':
    print Solution().containsNearbyDuplicate([-1, -1], 1)
