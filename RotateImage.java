/**
 * Created by yhf on 15/5/26.
 */

/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?

 0  1  2  3
 4  5  6  7
 8  9 10 11
12 13 14 15

*/

public class RotateImage {
    public static void rotate(int[][] matrix) {
        for (int layer = 0; layer < matrix.length / 2; layer++) {
            int first = layer, last = matrix.length - 1 - layer;
            for (int i = first; i < last; i++) {
                int temp = matrix[i][first];
                matrix[i][first] = matrix[last][i];               // 12 -> 0, 13 -> 4, bottom -> left
                matrix[last][i] = matrix[last + first - i][last];         // 15 -> 12, 11 -> 13
                matrix[last + first - i][last] = matrix[first][last + first - i]; // 3 -> 15, 2 -> 11
                matrix[first][last + first - i] = temp;                   // 0 -> 3, 4 -> 2
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15}
        };
        rotate(matrix);
    }
}
