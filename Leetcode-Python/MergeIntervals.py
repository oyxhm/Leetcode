"""
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

[1,12], [2,6], [7,8], [9,10], [11-14]
[1,12]
"""


class Interval:
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

    def __str__(self):
        return "Interval [%s]" % str((self.start, self.end))

    def __repr__(self):
        return "[%s, %s]" % (self.start, self.end)


def cmp(i1, i2):
    return i1.start.__cmp__(i2.start) * 2 + i1.end.__cmp__(i2.end)

Interval.__cmp__ = cmp


class Solution:
    # @param {Interval[]} intervals
    # @return {Interval[]}
    def merge(self, intervals):
        if not intervals:
            return []
        intervals = sorted(intervals)
        merged = []

        pre = intervals[0]
        for interval in intervals[1:]:
            if interval.start <= pre.end:
                pre.end = max(pre.end, interval.end)
            else:
                merged.append(pre)
                pre = interval

        merged.append(pre)
        return merged


if __name__ == '__main__':
    # intervals = [Interval(2, 18), Interval(8, 10), Interval(2, 6), Interval(1, 3)]
    intervals = [Interval(1, 4), Interval(2, 5)]
    print Solution().merge(intervals)
