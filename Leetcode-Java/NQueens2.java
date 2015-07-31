import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhf on 15/5/29.
 */

/*
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
*/

public class NQueens2 {
    public static int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        List<int[]> res = new ArrayList<>();
        int[] rows = new int[n];
        solveNQueens(n, rows, 0, res);
        return res.size();
    }

    private static void solveNQueens(int n, int[] rows, int row, List<int[]> res) {
        if (row >= n) {
            int[] temp = new int[n];
            System.arraycopy(rows, 0, temp, 0, n);
            res.add(temp);
            return;
        }

        for (int colIdx = 0; colIdx < rows.length; colIdx++) {
            boolean colExist = false;
            for (int rowIdx = 0; rowIdx < row; rowIdx++) {
                if (!isValid(rowIdx, rows[rowIdx], row, colIdx)) {
                    colExist = true;
                    break;
                }
            }
            if (!colExist) {
                rows[row] = colIdx;
                solveNQueens(n, rows, row + 1, res);
                rows[row] = 0;
            }
        }
    }

    private static boolean isValid(int x1, int y1, int x2, int y2) {
        return x1 != x2 && y1 != y2 && Math.abs(x1 - x2) != Math.abs(y1 - y2);
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }
}
