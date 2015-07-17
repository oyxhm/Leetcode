"""
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input: Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
"""


class Solution:
    # @param {string} digits
    # @return {string[]}
    def letterCombinations(self, digits):
        if not digits:
            return []
        d_l_map = {
            "2": "abc", "3": "def", "4": "ghi", "5": "jkl",
            "6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz"
        }
        queue = [""]
        for digit in digits:
            size = len(queue)
            for _ in xrange(size):
                cur = queue.pop(0)
                for letter in d_l_map.get(digit):
                    queue.append(cur + letter)
        return queue

    def letterCombinations2(self, digits):
        if not digits:
            return []
        d_l_map = {
            "2": "abc", "3": "def", "4": "ghi", "5": "jkl",
            "6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz"
        }
        res = []

        def __letterCombinations(idx, cur):
            if idx == len(digits):
                res.append(cur)
                return
            for letter in d_l_map.get(digits[idx]):
                __letterCombinations(idx+1, cur+letter)

        __letterCombinations(0, "")
        return res


if __name__ == '__main__':
    print Solution().letterCombinations("23")
