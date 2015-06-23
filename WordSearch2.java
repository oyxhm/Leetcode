import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yhf on 15/6/23.
 */

/*
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
Note:
You may assume that all inputs are consist of lowercase letters a-z.

You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?

If the current candidate does not exist in all words' prefix, you could stop backtracking immediately. What kind of data
structure could answer such query efficiently? Does a hash table work? Why or why not? How about a Trie? If you would
like to learn how to implement a basic trie, please work on this problem: Implement Trie (Prefix Tree) first.
*/

public class WordSearch2 {
    public static List<String> findWords(char[][] board, String[] words) {
        Trie t = buildTrie(words);
        Set<String> res = new HashSet<>();
        if (board.length == 0 || board[0].length == 0 || words.length == 0) {
            return new ArrayList<String>(res);
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                findWords(board, i, j, visited, t, "", res);
            }
        }
        return new ArrayList<String>(res);
    }

    private static Trie buildTrie(String[] words) {
        Trie t = new Trie();
        for (String word : words) {
            t.insert(word);
        }
        return t;
    }

    private static void findWords(char[][] board, int i, int j, TrieNode node, List<Character> cur, List<String> res, Set<Integer> visited, Set<String> existWords) {
        // Time Limit Exceeded
        int m = board.length, n = board[0].length;
        int index = i * n + j;
        node.children.values().stream().filter(child -> {
            return !visited.contains(index) && board[i][j] == child.val;
        }).forEach(child -> {
            cur.add(board[i][j]);
            visited.add(index);
            if (i > 0) {
                findWords(board, i - 1, j, child, cur, res, visited, existWords);
            }
            if (i < board.length - 1) {
                findWords(board, i + 1, j, child, cur, res, visited, existWords);
            }
            if (j > 0) {
                findWords(board, i, j - 1, child, cur, res, visited, existWords);
            }
            if (j < board[0].length - 1) {
                findWords(board, i, j + 1, child, cur, res, visited, existWords);
            }
            if (child.isLeaf && !existWords.contains(listToString(cur))) {
                res.add(listToString(cur));
                existWords.add(listToString(cur));
            }
            visited.remove(index);
            cur.remove(cur.size() - 1);
        });
    }

    private static String listToString(List<Character> list) {
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }

    private static void findWords(char[][] board, int i, int j, Set<Integer> visited, Trie t, String cur, Set<String> res) {
        int m = board.length, n = board[0].length;
        int entry = i * n + j;
        if (i < 0 || i >= m || j < 0 || j >= n || visited.contains(entry)) {
            return;
        }
        cur += board[i][j];
        if (!t.startsWith(cur)) {
            return;
        }
        if (t.search(cur)) {
            res.add(cur);   // 注意这里不要返回，继续搜索
        }
        visited.add(entry);
        findWords(board, i - 1, j, visited, t, cur, res);
        findWords(board, i + 1, j, visited, t, cur, res);
        findWords(board, i, j - 1, visited, t, cur, res);
        findWords(board, i, j + 1, visited, t, cur, res);
        visited.remove(entry);
    }

    public static void main(String[] args) {
        /*char[][] board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};*/
        char[][] board = new char[][]{{'a', 'a'}};
        // String[] words = new String[]{"oath", "pea", "eat", "rain"};
        String[] words = new String[]{"a"};
        List<String> res = findWords(board, words);
    }
}
