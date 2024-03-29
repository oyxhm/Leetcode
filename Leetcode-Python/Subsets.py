"""
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
"""


class Solution:
    # @param {integer[]} nums
    # @return {integer[][]}
    def subsets(self, nums):
        res = []
        nums.sort()

        def __subsets(idx, cur):
            if idx == len(nums):
                res.append(cur)
                return
            __subsets(idx + 1, cur+[nums[idx]])
            __subsets(idx + 1, list(cur))

        __subsets(0, [])
        return res

    def subsetsBFS(self, nums):
        res = [[]]
        nums.sort()
        for num in nums:
            size = len(res)
            for cur in res[:size]:
                temp = list(cur)
                temp.append(num)
                res.append(temp)
        return res

if __name__ == '__main__':
    print Solution().subsetsBFS([4,1,0])
