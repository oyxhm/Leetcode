class ValidPalindrome {
	// O(n) runtime, O(1) space

	public static boolean validPalindrome(String s) {
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
			System.out.printf("%s is %b%n", s, validPalindrome(s));	
		}
	}
}