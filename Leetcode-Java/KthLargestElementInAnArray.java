/**
 * Created by yhf on 15/5/28.
 */

/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

public class KthLargestElementInAnArray {
    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        for (int i = len / 2; i >= 0; i--) {
            maxHeapAdjust(nums, i, len);
        }
        int count = k;
        len--;
        while (count > 0) {
            int temp = nums[0];
            nums[0] = nums[len];
            nums[len] = temp;
            maxHeapAdjust(nums, 0, len--);
            count--;
        }
        return nums[nums.length - k];
    }

    public static void heapSort(int[] nums) {
        int len = nums.length;
        for (int i = len / 2; i >= 0; i--) {
            maxHeapAdjust(nums, i, len);
        }
        len--;
        while (len > 0) {
            int temp = nums[0];
            nums[0] = nums[len];
            nums[len] = temp;
            maxHeapAdjust(nums, 0, len--);
        }
    }

    public static void minHeapAdjust(int[] nums, int i, int N) {
        int temp = nums[i], child;
        for ( ; i * 2 + 1 < N; i = child) {
            child = 2 * i + 1;
            if (child + 1 < N && nums[child] > nums[child + 1]) {
                child++;
            }
            if (temp > nums[child]) {
                nums[i] = nums[child];
            } else {
                break;
            }
        }
        nums[i] = temp;
    }

    public static void maxHeapAdjust(int[] nums, int i, int N) {
        int temp = nums[i], child;
        for ( ; i * 2 + 1 < N; i = child) {
            child = 2 * i + 1;
            if (child + 1 < N && nums[child] < nums[child + 1]) {
                child++;
            }
            if (temp < nums[child]) {
                nums[i] = nums[child];
            } else {
                break;
            }
        }
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 3, 2, 1};
//        heapSort(nums);
        int i = findKthLargest(nums, 2);
    }
}
