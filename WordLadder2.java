import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yhf on 15/5/3.
 */

/*
Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
All words have the same length.
All words contain only lowercase alphabetic characters.
*/

public class WordLadder2 {
    // Time Limit Exceeded, not Accepted.
    public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (start == null || end == null || start.equals("") || end.equals("")) {
            return res;
        }
        List<String> curPath = new ArrayList<String>();
        curPath.add(start);
        dict.add(end);
        dfs(end, dict, curPath, res);
        return res;
    }

    public static void dfs(String end, Set<String> dict, List<String> curPath, List<List<String>> res) {
        String str = curPath.get(curPath.size() - 1);
        for (int i = 0; i < str.length(); i++) {
            for (char c = 'a'; c < 'z'; c++) {
                char[] charArray = str.toCharArray();
                charArray[i] = c;
                String temp = new String(charArray);
                if (dict.contains(temp) && !curPath.contains(temp)) {
                    curPath.add(temp);
                    if (temp.equals(end)) {
                        List<String> tempPath = new ArrayList<String>(curPath);
                        res.add(tempPath);
                        return;
                    }
                    dfs(end, dict, curPath, res);
                    curPath.remove(curPath.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        String[] strs = {"hot", "dot", "dog", "lot", "log"};
        Set<String> dict = new HashSet<String>();
        for (String str : strs) {
            dict.add(str);
        }
        List<List<String>> res = findLadders(start, end, dict);
    }
}
