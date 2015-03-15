/*
Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for “abcabcbb” is “abc”, 
which the length is 3. For “bbbbb” the longest substring is “b”, with the length of 1.
*/


import java.util.*;

class LongestSubstringWithoutRepeatingCharacters {

	public static int longestSubstring(String s) {
		// O(n) runtime, O(1) space
		boolean[] exist = new boolean[256];
		int i = 0, maxLen = 0;
		for (int j = 0; j < s.length(); j++) {
			while (exist[s.charAt(j)]) {
				// find the index of char which is now repeated at j
				exist[s.charAt(i)] = false;
				i++;
			}
			exist[s.charAt(j)] = true;
			maxLen = Math.max(j - i + 1, maxLen);
		}
		return maxLen;
	}

	public static int longestSubstring2(String s) {
		// O(n) runtime, O(1) space
		int i = 0, maxLen = 0;
		int[] indexMap = new int[256];
		Arrays.fill(indexMap, -1);
		for (int j = 0; j < s.length(); j++) {
			if (indexMap[s.charAt(j)] != -1) {
				i = indexMap[s.charAt(j)];
			}
			indexMap[s.charAt(j)] = j;
			maxLen = Math.max(j - i, maxLen);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		System.out.println(longestSubstring("aacsdeapoi"));
		System.out.println(longestSubstring2("aacsdeapoi"));
	}
}