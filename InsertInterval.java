import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhf on 15/6/15.
 */

/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

Test cases:
[1, 3], [6, 9]            [2, 5]
[1, 3], [6, 9]            [2, 7]
[1, 3], [6, 9]  [10, 13]  [2, 12]
[1, 3], [6, 9]  [10, 11]  [2, 12]
[1, 3], [6, 9]  [11, 13]  [2, 10]
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class InsertInterval {
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                res.add(interval);
            } else if (interval.start > newInterval.end) {
                res.add(newInterval);
                newInterval = interval;
            } else if (interval.start <= newInterval.end || interval.end >= newInterval.start) {
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end));
            }
        }
        res.add(newInterval);
        return res;
    }

    public static void main(String[] args) {

    }
}
