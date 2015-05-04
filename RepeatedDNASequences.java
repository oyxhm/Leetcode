import java.util.*;

/**
 * Created by yhf on 15/5/4.
 */

/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify
repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that
occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
*/

public class RepeatedDNASequences {
    public static List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> set = new HashSet<Integer>();
        Set<String> resSet = new HashSet<String>();
        List<String> res = new ArrayList<String>();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0);  // 00
        map.put('C', 1);  // 01
        map.put('G', 2);  // 10
        map.put('T', 3);  // 11

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = (sum << 2) + map.get(s.charAt(i));  // 注意这里加括号，+具有优先级
            if (i >= 9) {
                sum = sum & ((1 << 20) - 1);  // 取后20位
                if (set.contains(sum)) {
                    resSet.add(s.substring(i - 9, i + 1));
                } else {
                    set.add(sum);
                }
            }
        }

        for (String str : resSet) {
            res.add(str);
        }

        return res;
    }

    public static void main(String[] args) {
        List<String> res = findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }
}
