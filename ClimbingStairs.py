"""
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
"""


class Solution:
    # @param {integer} n
    # @return {integer}
    def climbStairs(self, n):
        if 0 <= n <= 2:
            return n
        steps = [1, 2]
        for _ in xrange(n - 2):
            steps.append(steps[-2] + steps[-1])
        return steps[-1]


if __name__ == '__main__':
    assert Solution().climbStairs(3) == 3
