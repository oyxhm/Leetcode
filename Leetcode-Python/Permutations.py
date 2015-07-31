"""
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
"""


class Solution:
    # @param {integer[]} nums
    # @return {integer[][]}
    def permute(self, nums):
        res = []

        def __permute(nums, idx):
            if idx == len(nums) - 1:
                res.append(list(nums))
            for i in xrange(idx, len(nums)):
                nums[i], nums[idx] = nums[idx], nums[i]
                __permute(nums, idx + 1)
                nums[i], nums[idx] = nums[idx], nums[i]

        __permute(nums, 0)
        return res

    def permuteBFS(self, nums):
        if not nums:
            return []
        queue = [[nums[0]]]
        for num in nums[1:]:
            cur_len = len(queue[0])
            size = len(queue)
            for i in xrange(size):
                cur = queue.pop(0)
                for idx in xrange(cur_len + 1):
                    temp = list(cur)
                    temp.insert(idx, num)
                    queue.append(temp)
        return queue


if __name__ == '__main__':
    print Solution().permuteBFS([1, 2, 3])
