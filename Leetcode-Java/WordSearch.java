import java.util.HashSet;
import java.util.Set;

/**
 * Created by yhf on 15/5/31.
 */

/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or
vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        Set<Integer> visited = new HashSet<>();
        boolean res = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                res = res || exist(board, word, 0, i, j, visited);
            }
        }
        return res;
    }

    private static boolean exist(char[][] board, String word, int idx, int i, int j, Set<Integer> visited)  {
        int index = i * board[0].length + j;
        if (visited.contains(index)) {
            return false;
        }
        visited.add(index);
        if (word.charAt(idx) == board[i][j]) {
            if (idx == word.length() - 1) {
                return true;
            }
            boolean ret = false;
            if (i > 0 && exist(board, word, idx + 1, i - 1, j, visited)) {
                return true;
            }
            if (i < board.length - 1 && exist(board, word, idx + 1, i + 1, j, visited)) {
                return true;
            }
            if (j > 0 && exist(board, word, idx + 1, i, j - 1, visited)) {
                return true;
            }
            if (j < board[0].length - 1 && exist(board, word, idx + 1, i, j + 1, visited)) {
                return true;
            }
            // 注意这里不可以return false，一定要先remove(index)
        }
        visited.remove(index);
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        };
        boolean res = exist(board, "AAB");
    }
}
