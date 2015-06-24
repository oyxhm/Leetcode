"""
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are
drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a
container, such that the container contains the most water.

Note: You may not slant the container.
"""


class Solution:
    # @param {integer[]} height
    # @return {integer}
    def maxArea(self, height):
        left = 0
        right = len(height) - 1
        max_area = 0
        while left < right:
            max_area = max(max_area, min(height[left], height[right]) * (right - left))
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        return max_area


if __name__ == '__main__':
    print Solution().maxArea([1, 1])
