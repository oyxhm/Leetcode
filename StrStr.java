/*
Implement strstr(). Returns the index of the first occurence of needle in haystack, or -1 
if needle is not part of haystack.
*/

import java.util.*;

class StrStr {
    public static int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) { 
                    return i;
                }
                if (i + j == haystack.length()) {
                    return j;
                }
                if (haystack.charAt(i) != needle.charAt(j)) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Map<String, String> testCases = new HashMap<String, String>();
        testCases.put("abbbc", "bb");
        testCases.put("ascw", "w");
        testCases.put("", "a");
        testCases.put("a", "");
        testCases.put("", "");
        testCases.put("asdfg", "jkl");
        Iterator iter = testCases.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String haystack = (String) entry.getKey();
            String needle   = (String) entry.getValue();
            System.out.printf("%s %s %d%n", haystack, needle, strStr(haystack, needle));
        }
    }
}