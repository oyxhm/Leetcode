/*
Implement strstr(). Returns the index of the first occurence of needle in haystack, or -1 
if needle is not part of haystack.
*/

import java.util.*;

class StrStr {
    public static int strStr(String haystack, String needle) {
        // 因为内循环里，至少肯定会达到j == needle.length的条件，
        // 所以最后不用return语句
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) { 
                    return i;
                }
                if (i + j == haystack.length()) {
                    return -1;
                }
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(strStr("", "a"));
        System.out.println(strStr("abbbc", "bb"));
        System.out.println(strStr("ascw", "w"));
        System.out.println(strStr("a", ""));
        System.out.println(strStr("", ""));
        System.out.println(strStr("asdfg", "weq"));
    }
}