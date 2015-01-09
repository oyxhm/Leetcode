/* Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution. */

import java.util.*;

class TwoSum {

    public static int[] twoSum(int[] numbers, int target) {
        // O(n) runtime, O(n) space
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int x = numbers[i];
            if (map.containsKey(target - x)) {
                return new int[] { map.get(target - x) + 1, i + 1 };
            }
            map.put(x, i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum2(int[] numbers, int target) {
        // numbers is sorted 
        // O(n log n) runtime, O(1) space
        for (int i = 0; i <= numbers.length; i++) {
            int idx = bsearch(numbers, target - numbers[i], i + 1);
            if (idx != -1) {
                return new int[] { i + 1, idx + 1 };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    private static int bsearch(int[] numbers, int target, int start) {
        int left = start, right = numbers.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > target) {
                right = mid - 1;
            } else if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int[] twoSum3(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
        	int sum = numbers[i] + numbers[j];
        	if (sum < target) {
	            i++;
	        } else if (sum > target) {
	        	j--;
	        } else {
	        	return new int[] { i + 1, j + 1 };
	        }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 8, 10, 11};
        int[] ret = twoSum3(numbers, 18);
        System.out.println(ret[0]);
        System.out.println(ret[1]);
    }
}
