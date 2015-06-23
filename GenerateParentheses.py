"""
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
"""


class Solution:
    # @param {integer} n
    # @return {string[]}
    def generateParenthesis(self, n):
        self.__res = []

        def __generateParentheses(num_left, num_unmatched_left, cur_str):
            if num_left == n and not num_unmatched_left:
                self.__res.append(cur_str)
                return
            if num_left < n:
                __generateParentheses(num_left + 1, num_unmatched_left + 1, cur_str + '(')
            if num_unmatched_left:
                __generateParentheses(num_left, num_unmatched_left - 1, cur_str + ')')

        __generateParentheses(0, 0, "")
        return self.__res


if __name__ == '__main__':
    print Solution().generateParenthesis(3)
