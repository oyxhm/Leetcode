"""
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
"""


class Solution:
    # @param {string} s
    # @return {string[][]}
    def partition(self, s):
        res = []

        def __is_palindrome(s):
            return s == s[::-1]

        def __partioning(index, cur):
            if index >= len(s):
                res.append(list(cur))
                return
            for i in xrange(index, len(s)):
                if __is_palindrome(s[index:i+1]):
                    __partioning(i+1, cur+[s[index:i+1]])

        __partioning(0, [])

        return res


if __name__ == '__main__':
    print Solution().partition("aab")
