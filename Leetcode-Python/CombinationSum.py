# encoding: utf-8
"""
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate
numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7,
A solution set is:
[7]
[2, 2, 3]
"""


class Solution:
    # @param {integer[]} candidates
    # @param {integer} target
    # @return {integer[][]}
    def combinationSum(self, candidates, target):
        res = []
        candidates.sort()

        def __combinationSum(idx, cur, cur_sum):
            if cur_sum == target:
                res.append(cur)
                return
            if cur_sum > target:
                return
            for i in xrange(idx, len(candidates)):
                __combinationSum(i, cur+[candidates[i]], cur_sum+candidates[i])

        __combinationSum(0, [], 0)
        return res


if __name__ == '__main__':
    candidates = [2, 3, 6, 7]
    print Solution().combinationSum(candidates, 7)
