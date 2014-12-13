/* 
Similar to Question [Reverse Words in a String], but with the following constraints:
“The input string does not contain leading or trailing spaces and the words are always separated by a single space.”
Could you do it in-place without allocating extra space?
*/

class ReverseWordsInAString2 {
    // O(n) runtime, O(1) space

    public static void reverseWords(char[] s) {
        reverse(s, 0, s.length);
        for (int i = 0, j = 0; i <= s.length; i++) {
            if (i == s.length || s[i] == ' ') {
                reverse(s, j, i);
                j = i + 1;
            }
        }
    }

    public static void reverse(char[] s, int start, int end) {
        for (int i = 0; i < (end - start) / 2; i++) {
            char temp = s[start + i];
            s[start + i] = s[end - i - 1];
            s[end - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        char[][] testCases = {
            {'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'},
            {'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd', '!'}
        };
        for (char[] sentence : testCases) {
            reverseWords(sentence);
            System.out.println(sentence);
        }
    }
}