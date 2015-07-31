# encoding: utf-8
"""
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C
where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8,
A solution set is:
[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]
"""


class Solution:
    # @param {integer[]} candidates
    # @param {integer} target
    # @return {integer[][]}
    def combinationSum2(self, candidates, target):
        candidates = sorted(candidates)
        num_candidates = len(candidates)
        self.res = []

        def __combinationSum2(idx, cur, cur_sum):
            if cur_sum > target or idx > num_candidates:
                return
            if cur_sum == target:
                self.res += [cur]
                return
            i = idx
            while i < num_candidates:
                __combinationSum2(i+1, cur+[candidates[i]], cur_sum+candidates[i])
                while i < num_candidates - 1 and candidates[i] == candidates[i+1]:
                    i += 1
                i += 1

        __combinationSum2(0, [], 0)
        return self.res


if __name__ == '__main__':
    print Solution().combinationSum2([1, 1, 2, 5, 6, 7, 10], 8)
