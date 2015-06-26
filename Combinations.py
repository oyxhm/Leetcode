"""
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
"""


class Solution:
    # @param {integer} n
    # @param {integer} k
    # @return {integer[][]}
    def combine(self, n, k):
        self.__res = []
        if n <= 0 or k <= 0:
            return self.__res

        def __combine(cur, idx):
            if len(cur) == k:
                self.__res.append(list(cur))
                return
            if idx > n:
                return
            cur.append(idx)
            __combine(cur, idx + 1)
            cur.pop()
            __combine(cur, idx + 1)

        __combine([], 1)
        return self.__res


if __name__ == '__main__':
    print Solution().combine(4, 2)
