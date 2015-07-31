/**
 * Created by yhf on 15/5/23.
 */

/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

http://fisherlei.blogspot.com/2012/12/leetcode-next-permutation.html

6 8 7 4 3 2
1. from right to left, find the first element which violates the increasing trend, called PartitionNumber, that is 6.
2. from right to left, find the first element which is larger than PartitionNumber, called ChangeNumber, that is 7.
3. swap PartitionNumber and ChangeNumber, now becomes 7 8 6 4 3 2
4. reverse the current array on the right of the partition index, now becomes 7 2 3 4 6 8
*/



public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int partition = -1, change = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                partition = i;
                break;
            }
        }

        if (partition != -1) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[partition]) {
                    change = i;
                    break;
                }
            }
        }

        if (partition != -1 && change != -1) {
            int temp = nums[partition];
            nums[partition] = nums[change];
            nums[change] = temp;
        }


        for (int i = partition + 1, j = nums.length - 1; i <= j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1};
        nextPermutation(nums);
    }
}
