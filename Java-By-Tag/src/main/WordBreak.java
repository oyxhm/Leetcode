package src.main;

/**
 * Created by yhf on 8/24/15.
 */

import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of
 * one or more dictionary words.
 *
 * For example, given
 *
 * s = "leetcode",
 * dict = ["leet", "code"].
 *
 * Return true because "leetcode" can be segmented as "leet code".
 */

public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean dp[] = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (wordDict.contains(s.substring(0, i + 1))) {
                dp[i] = true;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j + 1, i + 1))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length() - 1];
    }
}
