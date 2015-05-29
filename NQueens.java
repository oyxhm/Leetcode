import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhf on 15/5/29.
 */

/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:


// 用一个一维数组表示每行皇后的位置，如rows[1]表示第二行的皇后位置

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

public class NQueens {
    public static List<String[]> solveNQueens(int n) {
        List<int[]> res = new ArrayList<>();
        List<String[]> ret = new ArrayList<>();
        if (n <= 0) {
            return ret;
        }
        int[] rows = new int[n];
        solveNQueens(n, rows, 0, res);
        for (int[] solution : res) {
            String[] strs = new String[n];
            for (int rowIdx = 0; rowIdx < n; rowIdx++) {
                String s = "";
                for (int i = 0; i < n; i++) {
                    if (i == solution[rowIdx]) {
                        s += 'Q';
                    } else {
                        s += '.';
                    }
                }
                strs[rowIdx] = s;
            }
            ret.add(strs);
        }
        return ret;
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
        List<String[]> res = solveNQueens(4);
    }
}
