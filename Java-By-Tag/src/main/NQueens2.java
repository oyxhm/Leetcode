package src.main;

/**
 * Created by yhf on 10/10/15.
 */

import java.util.List;

/**
 * Follow up for N-Queens problem.
 * <p>
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 */

public class NQueens2 {

    private int count = 0;

    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        totalNQueens(n, new int[n], 0);
        return count;
    }

    private void totalNQueens(int n, int[] rows, int row) {
        if (row == n) {
            count++;
        }

        for (int colIdx = 0; colIdx < rows.length; colIdx++) {
            boolean existsInvalid = false;
            for (int rowIdx = 0; rowIdx < row; rowIdx++) {
                if (!isValid(rowIdx, rows[rowIdx], row, colIdx)) {
                    existsInvalid = true;
                    break;
                }
            }
            if (!existsInvalid) {
                rows[row] = colIdx;
                totalNQueens(n, rows, row + 1);
                rows[row] = 0;
            }
        }
    }

    private boolean isValid(int x1, int y1, int x2, int y2) {
        return x1 != x2 && y1 != y2 && Math.abs(x1 - x2) != Math.abs(y1 - y2);
    }
}
