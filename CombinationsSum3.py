"""
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used
and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
"""


class Solution:
    # @param {integer} k
    # @param {integer} n
    # @return {integer[][]}
    def combinationSum3(self, k, n):
        res = []

        def __combinationSum(idx, cur, sum):
            if sum == n and len(cur) == k:
                res.append(list(cur))
                return
            if sum > n or len(cur) >= k or idx == 10:
                return
            cur.append(idx)
            __combinationSum(idx + 1, cur, sum + idx)
            cur.pop()
            __combinationSum(idx + 1, cur, sum)

        __combinationSum(1, [], 0)
        return res


if __name__ == '__main__':
    print Solution().combinationSum3(3, 9)
