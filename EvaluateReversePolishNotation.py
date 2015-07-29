"""
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
"""


class Solution:
    # @param {string[]} tokens
    # @return {integer}
    def evalRPN(self, tokens):
        opr_map = {
            "+": lambda x, y: x + y,
            "-": lambda x, y: x - y,
            "*": lambda x, y: x * y,
            "/": lambda x, y: x / y if x / y >= 0 or x % y == 0 else x / y + 1
        }
        oprs = opr_map.keys()
        stack = []
        for token in tokens:
            if token in oprs:
                num2 = stack.pop()
                num1 = stack.pop()
                stack.append(opr_map[token](num1, num2))
            else:
                stack.append(int(token))
        return stack.pop()
