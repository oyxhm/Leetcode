/* 
* @Author: yhf
* @Date:   2015-04-06 17:19:05
* @Last Modified by:   yhf
* @Last Modified time: 2015-04-07 23:10:09
*/

public class LongestPalindromicSubstring {
	private static int expandFromCenter(String s, int center1, int center2) {
		int left = center1, right = center2;
		while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}

	public static String longestPalindrome(String s) {
		// O(n^2) runtime, O(1) space.

		if (s == "") {
			return "";
		}
		int left = 0, right = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandFromCenter(s, i, i);
			int len2 = expandFromCenter(s, i, i+1);
			int len = Math.max(len1, len2);
			if (len > right - left) {
				left = i - (len - 1) / 2;
				right = i + len / 2;	
			}
		}
		return s.substring(left, right + 1);
	}

	public static String longestPalindrome2(String s) {
		// dynamic programming
		// O(n^2) runtime, O(n^2) space

		if (s == "") {
			return "";			
		}
		int len = s.length();
		boolean[][] isPalindrome = new boolean[len][len];

		for (int i = 0; i < len; i++) {
			isPalindrome[i][i] = true;
		}
		int maxLength = 1;
		int left = 0;

		for (int i = 0; i < len - 1; i++) {
			if (s.charAt(i) == s.charAt(i+1)) {
				isPalindrome[i][i+1] = true;
				maxLength = 2;
				left = i;
			}
		}

		for (int l = 3; l <= len; l++) {   // notice when l == len
			for (int i = 0; i < len - l + 1; i++) {
				int j = i + l - 1;
				if (s.charAt(i) == s.charAt(j) && isPalindrome[i+1][j-1]) {
					isPalindrome[i][j] = true;
					maxLength = l;
					left = i;
				}
			}
		}
		return s.substring(left, left + maxLength);
	}

    public static void main(String[] args) {
    	String test1 = "hhhabcdcbaqqq";
    	String test2 = "ccc";
    	String test3 = "a";
    	System.out.println(longestPalindrome(test1));
    	System.out.println(longestPalindrome(test2));
    	System.out.println(longestPalindrome(test3));
    	System.out.println(longestPalindrome2(test1));
    	System.out.println(longestPalindrome2(test2));
    	System.out.println(longestPalindrome2(test3));
    }
}