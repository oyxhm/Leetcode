/*
Given an input string s, reverse the string word by word.
For example, given s = "the sky is blue", return "blue is sky the".
*/

class ReverseWordsInAString {
    // O(n) runtime, O(n) space

    public static String reverseWords(String s) {
        StringBuilder reversed = new StringBuilder();
        int len = s.length(), j = len;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                j = i;
            } else if (i == 0 || s.charAt(i - 1) == ' ') {
                if (reversed.length() != 0) {
                    reversed.append(' ');
                }
                reversed.append(s.substring(i, j));
            }
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        String[] testCases = {"hello world", " hello  world! "};
        for (String sentence : testCases) {
            System.out.println(reverseWords(sentence));
        }
        System.out.println("hello world!");
    }
}