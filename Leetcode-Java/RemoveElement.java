/**
 * Created by yhf on 15/4/13.
 */

/*
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/

public class RemoveElement {
    public static int removeElement(int[] A, int elem) {
        int len = A.length;
        int i, r = len - 1;
        for (i = 0; i <= r; i++) {
            if (A[i] == elem) {
                while (A[r] == elem) {
                    r--;
                    // 这里要注意，r向前移动，可能移动到i
                    // 要用<=，不能用==，如A = {1}, elem = 1的情况
                    if (r <= i) {
                        return i;
                    }
                }
                int temp = A[r];
                A[r--] = elem;
                A[i] = temp;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] A = {1};
        int B = removeElement(A, 1);
        System.out.println(B);
    }
}
