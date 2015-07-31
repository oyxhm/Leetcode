/**
 * Created by yhf on 15/4/17.
 */

/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
*/

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        // check rows
        for (int i = 0; i < 9; i++) {
            boolean[] existRow = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int indexRow = board[i][j] - '0';
                if (existRow[indexRow]) {
                    return false;
                }
                existRow[indexRow] = true;
            }
        }

        // check columns
        for (int j = 0; j < 9; j++) {
            boolean[] existCol = new boolean[10];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int indexCol = board[i][j] - '0';
                if (existCol[indexCol]) {
                    return false;
                }
                existCol[indexCol] = true;
            }
        }

        // check blocks
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean[] existBlock = new boolean[10];
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (board[i*3+m][j*3+n] == '.') {
                            continue;
                        }
                        int indexBlock = board[i*3+m][j*3+n] - '0';
                        if (existBlock[indexBlock]) {
                            return false;
                        }
                        existBlock[indexBlock] = true;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '.'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
    }
}
