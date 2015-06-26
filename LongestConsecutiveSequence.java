import java.util.HashSet;
import java.util.Set;

/**
 * Created by yhf on 15/6/24.
 */

/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 1;
        for (int num : nums) {
            int left = num - 1;
            int right = num + 1;
            while (set.contains(left)) {
                set.remove(left);
                left--;
            }
            while (set.contains(right)) {
                set.remove(right);
                right++;
            }
            longest = Math.max(right - left - 1, longest);
        }
        return longest;
    }

    public static void main(String[] args) {
        int longest = longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
    }
}
