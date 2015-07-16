"""
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
(each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
"""


class Solution:
    # @param {string} word1
    # @param {string} word2
    # @return {integer}
    def minDistance(self, word1, word2):
        # dp[i][j] means the min distance of strings with length i and length j.
        if not word1 or not word2:
            return len(word1) or len(word2)
        dp = [[0] * (len(word2) + 1) for _ in xrange(len(word1) + 1)]
        for i in xrange(len(word1) + 1):
            dp[i][0] = i
        for j in xrange(len(word2) + 1):
            dp[0][j] = j
        for i in xrange(len(word1)):
            for j in xrange(len(word2)):
                if word1[i] == word2[j]:
                    dp[i+1][j+1] = dp[i][j]
                else:
                    dp[i+1][j+1] = min(dp[i+1][j], dp[i][j+1], dp[i][j]) + 1
        return dp[i+1][j+1]


if __name__ == '__main__':
    print Solution().minDistance("adsafasdf", "fa")
