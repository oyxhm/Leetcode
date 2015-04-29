import java.util.HashMap;
import java.util.Map;

/**
 * Created by yhf on 15/4/29.
 */

/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while
preserving the order of characters. No two characters may map to the same character
but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
*/

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        Map<Character, Character> mapRev = new HashMap<Character, Character>();
        int len = t.length();
        for (int i = 0; i < len; i++) {
            char cS = s.charAt(i);
            char cT = t.charAt(i);
            if ( (map.containsKey(cS) && map.get(cS) != cT) ||
                 (mapRev.containsKey(cT) && mapRev.get(cT) != cS) ) {
                return false;
            } else {
                map.put(cS, t.charAt(i));
                mapRev.put(t.charAt(i), cS);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("ab", "aa"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
    }
}
