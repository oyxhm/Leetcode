/*
Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution.
*/

import java.util.*;

class TwoSum {

    public static int[] twoSum(int[] numbers, int target) {
        // O(n) runtime, O(n) space
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            int x = numbers[i];
            if (map.containsKey(target - x)) {
                return new int[] { map.get(target - x) + 1, i + 1 };
            }
            map.put(x, i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    
    public static void main(String[] args) {
        int[] numbers = {1, 10, 3, 8, 100, 11};
        int[] ret = twoSum(numbers, 19);
        System.out.println(ret[0]);
        System.out.println(ret[1]);
    }
}
