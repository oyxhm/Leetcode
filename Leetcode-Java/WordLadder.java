import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by yhf on 15/5/3.
 */

/*
Given two words (beginWord and endWord), and a dictionary, find the
length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if (beginWord == null || endWord == null || beginWord.equals("") || endWord.equals("")) {
            return 0;
        }
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        queue.add(beginWord);
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            dist++;
            for (int i = 0; i < size; i++) {
                String str = queue.remove();
                for (int j = 0; j < str.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char[] strArray = str.toCharArray();
                        strArray[j] = c;
                        String temp = new String(strArray); // 注意这里，一定要new一个；如果用toString则不行
                        if (temp.equals(endWord)) {
                            return dist + 1;
                        }
                        if (wordDict.contains(temp) && !visited.contains(temp)) {
                            queue.add(temp);
                            visited.add(temp);
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        String[] dict = {"hot", "dot", "dog", "lot", "log"};
        for (String s : dict) {
            set.add(s);
        }
        int dist = ladderLength("hit", "cog", set);
    }
}
