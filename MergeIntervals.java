import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yhf on 15/6/13.
 */

/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

class IntervalComparator implements Comparator<Interval> {
    public int compare(Interval i1, Interval i2) {
        return i1.start - i2.start;
    }
}

public class MergeIntervals {
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return intervals;
        }

        // sort first
        Collections.sort(intervals, new IntervalComparator());

        // then merge
        for (int i = 1; i < intervals.size(); ) {
            if (intervals.get(i).start <= intervals.get(i - 1).end) {
                if (intervals.get(i).end < intervals.get(i - 1).end) {
                } else {
                    intervals.get(i - 1).end = intervals.get(i).end;
                }
                intervals.remove(i);
            } else {
                i++;
            }
        }
        return intervals;
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(15, 18);
        Interval i2 = new Interval(8, 10);
        Interval i3 = new Interval(2, 5);
        Interval i4 = new Interval(1, 4);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);
        List<Interval> res = merge(intervals);
    }
}
