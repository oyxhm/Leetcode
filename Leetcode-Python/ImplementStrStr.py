"""
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
"""


class Solution:
    # @param {string} haystack
    # @param {string} needle
    # @return {integer}
    def strStr(self, haystack, needle):
        if not haystack and needle:
            return -1
        if not needle:
            return 0
        i = j = 0
        while i < len(haystack) - len(needle) + 1 and j < len(needle):
            start = i
            if haystack[i] == needle[0]:
                j = 0
                while j < len(needle) and haystack[i] == needle[j]:
                    i += 1
                    j += 1
                if j == len(needle):
                    return start
            i = start + 1
        return -1


if __name__ == '__main__':
    print Solution().strStr("mississippi", "issip")
