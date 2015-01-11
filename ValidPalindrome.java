/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
For example,
"A man, a plan, a canal: Panama" is a palindrome. "race a car" is not a palindrome.
Define empty string as valid palindrome.
*/

class ValidPalindrome {
	// O(n) runtime, O(1) space

	public static boolean isValidPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		for (;i < j; i++, j--) {
			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
				i++; 
			}
			while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
				j--;
			}
			if (Character.toLowerCase(s.charAt(i)) 
					!= Character.toLowerCase(s.charAt(j))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] testCases = {"abcba", "a Bcba", "a  b  cb   A", "a1 2a21a", " ", ""};
		for (String s : testCases) {
			System.out.printf("%s is %b%n", s, isValidPalindrome(s));	
		}
	}
}