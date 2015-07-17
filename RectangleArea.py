"""
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.
"""


class Solution:
    # @param {integer} A
    # @param {integer} B
    # @param {integer} C
    # @param {integer} D
    # @param {integer} E
    # @param {integer} F
    # @param {integer} G
    # @param {integer} H
    # @return {integer}
    def computeArea(self, A, B, C, D, E, F, G, H):
        area = (C - A) * (D - B) + (G - E) * (H - F)
        if D < F or H < B or G < A or C < E:
            return area

        left = max(A, E)
        right = min(C, G)
        top = min(D, H)
        bottom = max(B, F)

        return area - (right - left) * (top - bottom)
