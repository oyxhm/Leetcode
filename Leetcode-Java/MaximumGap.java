/**
 * Created by yhf on 15/5/31.
 */

/*
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
*/

public class MaximumGap {
    public static int maximumGap(int[] nums) {
        // find max and min
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // insert into buckets
        int[][] buckets = new int[nums.length + 1][2];    // 注意这里桶的个数
        for (int[] bucket : buckets) {   // bucket = [low, high]
            bucket[0] = -1;
            bucket[1] = -1;
        }
        double interval = (double) nums.length / (max - min);

        for (int num : nums) {
            int index = (int) ((num - min) * interval);
            if (buckets[index][0] == -1) { // first elem in this bucket
                buckets[index][0] = num;
                buckets[index][1] = num;
            } else {
                buckets[index][0] = Math.min(buckets[index][0], num);
                buckets[index][1] = Math.max(buckets[index][1], num);
            }
        }

        // scan to find the max gap
        int prevHigh = buckets[0][1];
        int maxGap = 0;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i][0] != -1) {
                maxGap = Math.max(buckets[i][0] - prevHigh, maxGap);
                prevHigh = buckets[i][1];
            }
        }
        return maxGap;
    }

    public static void main(String[] args) {
        int max = maximumGap(new int[]{1, 10000000});
    }
}
