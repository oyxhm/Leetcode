import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by yhf on 15/6/30.
 */

/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in
linear time and in O(1) space.

Think of it this way: Find three different votes and hide them. Repeat until there aren't three different votes left. A
number that originally had more than one third of the votes now still has at least one vote, because to hide all of its
votes you would've had to hide more than three times one third of the votes - more votes than there were. You can easily
have false positives, though, so in the end check whether the remaining up to two candidates actually had more than one
third of the votes.

My code does just that: Collect (count) the votes for every number, but remove triples of three different votes on the
fly, as soon as we have such a triple.

https://leetcode.com/discuss/42829/6-lines-general-case-o-n-time-and-o-k-space
*/

public class MajorityElement2 {
    public static List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
            if (counter.size() == 3) {
                for (int k : new HashSet<>(counter.keySet())) {
                    if (counter.get(k) > 1) {
                        counter.put(k, counter.get(k) - 1);
                    } else {
                        counter.remove(k);
                    }
                }
            }
        }

        for (int k : counter.keySet()) {
            counter.put(k, 0);
        }
        for (int num : nums) {
            if (counter.containsKey(num)) {
                counter.put(num, counter.get(num) + 1);
            }
        }

        return counter.keySet().stream()
                .filter(num -> counter.get(num) > nums.length / 3)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> l = majorityElement(new int[]{1, 1, 2, 3});
    }
}
