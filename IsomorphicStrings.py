"""
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters.
No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
"""


class Solution:
    # @param {string} s
    # @param {string} t
    # @return {boolean}
    def isIsomorphic(self, s, t):
        map_dict = {}
        map_reversed_dict = {}
        for x, y in zip(s, t):
            if map_dict.get(x):
                if map_dict.get(x) != y:
                    return False
            else:
                map_dict[x] = y
            if map_reversed_dict.get(y):
                if map_reversed_dict.get(y) != x:
                    return False
            else:
                map_reversed_dict[y] = x
        return True


if __name__ == '__main__':
    s = Solution()
    print s.isIsomorphic("egg", "add")
    print s.isIsomorphic("foo", "bar")
    print s.isIsomorphic("paper", "title")
    print s.isIsomorphic("ab", "aa")
