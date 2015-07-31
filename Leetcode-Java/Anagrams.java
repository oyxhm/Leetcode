/*
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
*/

import java.util.*;

public class Anagrams {
    public static List<String> anagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = String.valueOf(charArray);
            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(str);
            } else {
                map.put(sortedStr, new ArrayList<String>());
                map.get(sortedStr).add(str);
            }
        }
        List<String> l = new ArrayList<String>();
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            if (entry.getValue().toArray().length > 1) {
                for (String str : entry.getValue()) {
                    l.add(str);
                }
            }
        }
        return l;
    }

    public static void main(String[] args) {
        String[] strs = {"abc", "cba", "cab", "casb"};
        List<String> l = anagrams(strs);
        for (String str : l) {
            System.out.println(str);
        }
    }
}

