"""
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
"""


class Solution:
    # @param {string[]} strs
    # @return {string[]}
    def anagrams(self, strs):
        sorted_dict = {}
        for s in strs:
            sorted_s = "".join(sorted(s))
            if sorted_dict.get(sorted_s):
                sorted_dict.get(sorted_s).append(s)
            else:
                sorted_dict[sorted_s] = [s]
        ret = []
        for k, anagrams in sorted_dict.items():
            if len(anagrams) > 1:
                ret += anagrams
        return ret


if __name__ == '__main__':
    strs = ["abc", "cba", "bba", "bca"]
    print Solution().anagrams(strs)
