# encoding: utf-8
"""
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
"""


class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def maximumGap(self, nums):
        if len(nums) < 2:
            return 0
        MAX, MIN = max(nums), min(nums)
        buckets = [[-1, -1] for _ in xrange(len(nums) + 1)]  # [min, max]
        height = (MAX - MIN) * 1.0 / len(nums)   # 这里注意，不是len(buckets)

        for num in nums:
            idx = int((num - MIN) / height)
            print idx, len(buckets)
            if buckets[idx][0] == -1:
                buckets[idx] = [num, num]
            else:
                buckets[idx] = min(buckets[idx][0], num), max(buckets[idx][1], num)

        pre_max = max(buckets[0][1], 0)
        max_diff = max(0, buckets[0][1] - buckets[0][0])
        for bucket in buckets[1:]:
            if bucket[0] != -1:
                max_diff = max(max_diff, bucket[0] - pre_max, bucket[1] - bucket[0])  # n个数放进n+1个桶里，至少有一个空桶。最大差值肯定在两个不同的桶里
                pre_max = bucket[1]
        return max_diff


if __name__ == '__main__':
    print Solution().maximumGap([1, 1, 2, 2, 4, 100, 1000, 1010])
