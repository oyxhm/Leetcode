"""
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from
nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
"""


class Solution:
    # @param {integer[]} nums1
    # @param {integer} m
    # @param {integer[]} nums2
    # @param {integer} n
    # @return {void} Do not return anything, modify nums1 in-place instead.
    def merge(self, nums1, m, nums2, n):
        i = j = 0
        end = m
        while i < end and j < n:
            if nums1[i] > nums2[j]:
                nums1.insert(i, nums2[j])
                j += 1
                end += 1
            i += 1
        while j < n:
            nums1[end] = nums2[j]
            end += 1
            j += 1
        while len(nums1) > m + n:
            nums1.pop()


if __name__ == '__main__':
    nums1 = [1, 3, 5, 0, 0, 0, 0, 0, 0, 0]
    nums2 = [2, 4, 6, 8]
    Solution().merge(nums1, 0, nums2, len(nums2))
    print nums1
