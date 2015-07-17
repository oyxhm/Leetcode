# encoding: utf-8
"""
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
"""


class Solution:
    # @param {integer[]} nums
    # @param {integer} k
    # @return {integer}
    def findKthLargest(self, nums, k):
        from Queue import heapq
        heapq.heapify(nums)
        sorted_heap = [heapq.heappop(nums) for _ in xrange(len(nums))]
        return sorted_heap[-k]

    def findKthLargest2(self, nums, k):
        from Heap import Heap
        heap = Heap()
        for num in nums:
            heap.insert(num)
        for _ in xrange(k - 1):
            heap.delete_max()
        return heap.delete_max()

    def findKthLargest3(self, nums, k):
        pivot = nums[0]
        less, greater = [], []
        for num in nums[1:]:
            if num > pivot:
                greater.append(num)
            elif num < pivot:
                less.append(num)
        if k <= len(greater):    # 注意，k是反的
            return self.findKthLargest3(greater, k)
        elif k > len(nums) - len(less):   # 这里好好想想
            return self.findKthLargest3(less, k - (len(nums) - len(less)))
        return pivot


if __name__ == '__main__':
    print Solution().quickselect([-1, -1], 2)
