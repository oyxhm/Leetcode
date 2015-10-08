package src.main;

/**
 * Created by yhf on 10/7/15.
 */

/**
 * Given a string, find the length of the longest substring without repeating characters. For example, the longest
 * substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        boolean[] exist = new boolean[256];
        int i = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            while (exist[s.charAt(j)]) {
                i++;
                exist[s.charAt(i)] = false;
            }
            maxLen = Math.max(maxLen, j - i + 1);
            exist[s.charAt(j)] = true;
        }
        return maxLen;
    }
}
