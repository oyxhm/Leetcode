/**
 * Created by yhf on 15/4/17.
 */

/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].
*/

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] A) {
        int len = A.length;
        if (len <= 1) {
            return len;
        }
        int i = 0, j = 1;
        while (j < len) {
            if (A[j] == A[i]) {
                j++;
            } else {
                A[++i] = A[j++];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] A = {1, 1};
        System.out.println(removeDuplicates(A));
    }
}
