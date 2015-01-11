/*Similar to Question [1. Two Sum], except that the input array is already sorted in ascending order.*/

class TwoSum2 {

	public static int[] twoSum1(int[] numbers, int target) {
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

    public static int[] twoSum2(int[] numbers, int target) {
    	// O(n) runtime, O(1) space
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
}