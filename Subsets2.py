"""
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
"""


class Solution:
    # @param {integer[]} nums
    # @return {integer[][]}
    def subsetsWithDup(self, nums):
        res = [[]]
        nums.sort()

        def __subsetsWithDup(idx, cur):
            for i in xrange(idx, len(nums)):
                if i > idx and nums[i] == nums[i-1]:
                    continue
                cur.append(nums[i])
                res.append(list(cur))
                __subsetsWithDup(i+1, cur)
                cur.pop()
        __subsetsWithDup(0, [])
        return res


    def subsetsWithDup2(self, nums):
        nums.sort()
        res = [[]]
        start = 0
        for i in xrange(len(nums)):
            size = len(res)
            for subset in res[start:size]:
                temp = list(subset)
                temp.append(nums[i])
                res.append(temp)
            if i < len(nums) - 1 and nums[i] == nums[i + 1]:
                start = size
            else:
                start = 0
        return res


if __name__ == '__main__':
    print Solution().subsetsWithDup([1, 2, 2, 2])
