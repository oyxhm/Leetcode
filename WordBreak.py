"""
Given a string s and a dictionary of words dict, determine if s can be segmented
into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
"""


class Solution:
    # @param s, a string
    # @param wordDict, a set<string>
    # @return a boolean
    def wordBreak(self, s, wordDict):
        dp = [False] * len(s)

        for i in xrange(len(s)):
            if s[0:i+1] in wordDict:
                dp[i] = True
                continue

            for j in xrange(i):
                if dp[j] and s[j+1:i+1] in wordDict:
                    dp[i] = True
                    break

        return dp[-1]
