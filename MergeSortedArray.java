/**
 * Created by yhf on 15/4/17.
 */

/*
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional
elements from B. The number of elements initialized in A and B are m and n respectively.
*/

public class MergeSortedArray {
    public static void merge(int A[], int m, int B[], int n) {
        /*if (n == 0) {
            return;
        }*/
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (A[i] <= B[j]) {
                i++;
            } else if (A[i] > B[j]) {
                insert(A, i, B[j], m++);
                i++;
                j++;
            }
        }
        while (j < n) {
            A[i++] = B[j++];
        }
    }

    public static void insert(int A[], int index, int num, int size) {
        // insert num into A at index,
        // so elements after index and before size all move backward by 1
        for (int i = size; i > index; i--) {
            A[i] = A[i - 1];
        }
        A[index] = num;
    }

    public static void main(String[] args) {
        int[] A = new int[100];
        int[] B = new int[20];
        A[0] = 2;
        A[1] = 3;
        A[2] = 5;
        A[3] = 7;
        B[0] = 1;
        B[1] = 6;
        B[2] = 7;
        int m = 4, n = 3;
        merge(A, m, B, n);
    }
}
