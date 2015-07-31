/* 
 * Write a function to find the longest common prefix string amongst an array of strings.
 */

import java.util.*;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].length() == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        boolean stop = false;
        StringBuilder sb = new StringBuilder();
        int i = 0;                                   // index of a string
        while (true) {
            for (int j = 1; j < strs.length; j++) {  // index of strs
                if (i >= strs[j-1].length() || i >= strs[j].length() 
                    || strs[j].charAt(i) != strs[j-1].charAt(i)) {
                    // 这里要两两比较，注意第一次循环时j = 1，strs[0]可能长度为0，所以strs[j-1].charAt(i)可能
                    // 会StringIndexOutOfBoundsException，所以一开始加上strs[0].length() == 0的判断
                    stop = true;
                    break;
                }
            }
            if (stop == true) {
                break;
            }
            sb.append(strs[0].charAt(i++));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // String[] strs = {"", "hello", "helwwa", "heerewqfw"};
        // String[] strs = {"a"};
        // String[] strs = {"a", "aa"};
        String[] strs = {"aa", "a"};
        System.out.println(longestCommonPrefix(strs));
    }
}
