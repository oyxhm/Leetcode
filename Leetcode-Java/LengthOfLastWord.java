/**
 * Created by yhf on 15/4/17.
 */
/*

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example,
Given s = "Hello World",
return 5.
*/

import java.util.*;

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        String[] words = s.split("\\s");
        int len = words.length;
        return len == 0 ? 0 : words[len-1].length();
    }

    public static int lengthOfLastWord2(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length, i = len - 1;
        if (len == 0) {
            return 0;
        }
        while (i >= 0 && charArray[i] == ' ') {
            i--;
        }
        int lengthOfLastWord = 0;
        while (i >= 0 && charArray[i--] != ' ') {
            lengthOfLastWord++;
        }
        return lengthOfLastWord;
    }

    public static void reverse(char[] chars) {
        int len = chars.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            char temp = chars[l];
            chars[l++] = chars[r];
            chars[r--] = temp;
        }
    }

    public static void main(String[] args) {
        String s = "a";
        System.out.println(lengthOfLastWord2(s));
    }
}
