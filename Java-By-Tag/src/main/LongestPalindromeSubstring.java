package src.main;

/**
 * Created by yhf on 10/7/15.
 */

/**
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000,
 * and there exists one unique longest palindromic substring.
 */

public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        int max = 1, left = 0, right = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int len1 = spanFromCenter(s, i, i);
            int len2 = spanFromCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > max) {
                max = len;
                left = i - (len - 1) / 2;
                right = i + len / 2;
            }
        }
        return s.substring(left, right + 1);
    }

    private int spanFromCenter(String s, int c1, int c2) {
        int i = 0;
        while (c1 - i >= 0 && c2 + i < s.length() && s.charAt(c1-i) == s.charAt(c2 + i)) {
            i++;
        }
        return 2 * i - 1 + (c2 - c1);
    }
}
