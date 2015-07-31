import java.util.HashSet;
import java.util.Set;

/**
 * Created by yhf on 15/4/20.
 */

/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

public class WordBreak {
    public static boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len];

        for (int i = 0; i < len; i++) {
            if (wordDict.contains(s.substring(0, i + 1))) {
                dp[i] = true;
                continue;
            }

            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j + 1, i + 1))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[len-1];
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("leet");
        set.add("code");
        System.out.println(wordBreak("leetcode", set));
    }
}
