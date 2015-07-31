"""
Write a function to find the longest common prefix string amongst an array of strings.
"""


class Solution:
    # @param {string[]} strs
    # @return {string}
    def longestCommonPrefix(self, strs):
        prefix = ""
        if not strs:
            return prefix
        for idx in xrange(len(strs[0])):
            c = strs[0][idx]
            for s in strs[1:]:
                if idx >= len(s) or s[idx] != c:
                    return prefix
            prefix += c
        return prefix


if __name__ == '__main__':
    strs = ["abcd", "abcde", "abcdtas"]
    print Solution().longestCommonPrefix(strs)
