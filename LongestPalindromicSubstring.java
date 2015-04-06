/* 
* @Author: yhf
* @Date:   2015-04-06 17:19:05
* @Last Modified by:   yhf
* @Last Modified time: 2015-04-06 17:36:59
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

    public static void main(String[] args) {
    	String test1 = "hhhabcdcbaqqq";
    	String test2 = "";
    	String test3 = "a";
    	System.out.println(longestPalindrome(test1));
    	System.out.println(longestPalindrome(test2));
    	System.out.println(longestPalindrome(test3));
    }
}