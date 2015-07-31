import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhf on 15/4/30.
 */

/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
["aa","b"],
["a","a","b"]
]
*/

public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> partitioning = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<String>();
        dfs(s, 0, temp, partitioning);
        return partitioning;
    }

    public static void dfs(String s, int index, List<String> temp, List<List<String>> partitioning) {
        if (index == s.length()) {
            partitioning.add(new ArrayList<String>(temp)); // 注意这里要重新new一个
        }
        for (int i = index + 1; i <= s.length(); i++) {
            if (isPalindrome(s.substring(index, i))) {
                temp.add(s.substring(index, i));
                dfs(s, i, temp, partitioning);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> partitioning = partition("aab");
    }
}
