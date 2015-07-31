"""
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it
is able to trap after raining.

For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
"""


class Solution:
    # @param {integer[]} height
    # @return {integer}
    def trap(self, height):
        left_highest = [0]
        right_highest = [0]
        highest = 0
        for i in xrange(len(height) - 1):
            highest = (max(highest, height[i]))
            left_highest.append(highest)
        highest = 0
        for i in xrange(len(height) - 1, 0, -1):
            highest = (max(highest, height[i]))
            right_highest.insert(0, highest)

        sum = 0
        for i, num in enumerate(height):
            sum += max(min(left_highest[i], right_highest[i]) - num, 0)
        return sum

if __name__ == '__main__':
    print Solution().trap([0,1,0,2,1,0,1,3,2,1,2,1])
