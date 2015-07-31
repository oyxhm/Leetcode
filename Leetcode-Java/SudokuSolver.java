import com.sun.org.apache.xpath.internal.functions.FuncFalse;

/**
 * Created by yhf on 15/6/28.
 */

/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.
*/

public class SudokuSolver {
    public static void solveSudoku(char[][] board) {
        solveSudoku(board, 0);
    }

    private static boolean solveSudoku(char[][] board, int index) {
        if (index == 9 * 9) {
            return true;
        }
        int x = index / 9;
        int y = index % 9;
        if (board[x][y] != '.') {
            return solveSudoku(board, index + 1);
        } else {
            for (int num = 1; num <= 9; num++) {
                board[x][y] = (char) ('0' + num);
                if (isValid(board, x, y)) {
                    if (solveSudoku(board, index + 1)) {
                        return true;
                    }
                }
            }
            board[x][y] = '.';
            return false;
        }
    }

    private static boolean isValid(char[][] board, int x, int y) {
        for (int k = 0; k < 9; k++) {
            if (k != y && board[x][k] == board[x][y] || k != x && board[k][y] == board[x][y]) {
                return false;
            }
        }

        for (int i = x / 3 * 3; i < (x / 3 + 1) * 3; i++) {
            for (int j = y / 3 * 3; j < (y / 3 + 1) * 3; j++) {
                if (!(i == x && j == y) && board[i][j] == board[x][y]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] rows = {"..9748...", "7........", ".2.1.9...", "..7...24.", ".64.1.59.", ".98...3..", "...8.3.2.", "........6", "...2759.."};
        char[][] board = new char[9][9];
        int index = 0;
        for (String row : rows) {
            for (char c : row.toCharArray()) {
                int x = index / 9;
                int y = index++ % 9;
                board[x][y] = c;
            }
        }
        solveSudoku(board);
    }
}
