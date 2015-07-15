"""
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
"""


class Solution:
    # @param {string} s
    # @return {boolean}
    def isValid(self, s):
        parentheses_map = {'(': ')', '{': '}', '[': ']'}
        stack = list()
        for c in s:
            if c in parentheses_map.keys():
                stack.append(c)
            else:
                if not stack or parentheses_map.get(stack.pop()) != c:
                    return False
        return len(stack) == 0
