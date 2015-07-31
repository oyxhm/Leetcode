/**
 * Created by yhf on 15/5/23.
 */

/*
Set Matrix Zeroes Total Accepted: 35966 Total Submissions: 114006 My Submissions Question Solution
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/

public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        boolean setFirstColumnZeroes = false, setFirstRowZeroes = false;
        int numRows = matrix.length, numColumns = matrix[0].length;

        for (int i = 0; i < numRows; i++) {
            if (matrix[i][0] == 0) {
                setFirstColumnZeroes = true;
                break;
            }
        }
        for (int j = 0; j < numColumns; j++) {
            if (matrix[0][j] == 0) {
                setFirstRowZeroes = true;
                break;
            }
        }

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < numRows; i++) {    // 注意，要从1开始。因为0行0列是用来保存记录的，不能被毁坏
            for (int j = 1; j < numColumns; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (setFirstColumnZeroes) {
            for (int i = 0; i < numRows; i++) {
                matrix[i][0] = 0;
            }
        }
        if (setFirstRowZeroes) {
            for (int j = 0; j < numColumns; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0,0,0,5},
                {4,3,1,4},
                {0,1,1,4},
                {1,2,1,3},
                {0,0,1,1}};
        setZeroes(matrix);
    }
}
