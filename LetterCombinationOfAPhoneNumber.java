import java.util.*;

/**
 * Created by yhf on 15/5/1.
 */

/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order,
your answer could be in any order you want.

2   abc
3   def
4   ghi
5   jkl
6   mno
7   pqrs
8   tuv
9   wxyz
*/

public class LetterCombinationOfAPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        Queue<StringBuilder> queue = new LinkedList<StringBuilder>();
        int index = 0;
        char firstDigit = digits.charAt(index);
        for (char c : map.get(firstDigit).toCharArray()) {
            StringBuilder sb = new StringBuilder();
            sb.append(c);
            queue.add(sb);
        }
        while (++index < digits.length()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                StringBuilder temp = queue.remove();
                for (char c : map.get(digits.charAt(index)).toCharArray()) {
                    StringBuilder cur = new StringBuilder(temp.toString());
                    cur.append(c);
                    queue.add(cur);
                }
            }
        }
        while (!queue.isEmpty()) {
            StringBuilder sb = queue.remove();
            combinations.add(sb.toString());
        }
        return combinations;
    }

    public static List<String> letterCombinations2(String digits) {
        // dfs
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        StringBuilder sb = new StringBuilder();
        dfs(digits, 0, sb, combinations);
        return combinations;
    }

    public static void dfs(String digits, int index, StringBuilder sb, List<String> combinations) {
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (index == digits.length()) {
            combinations.add(sb.toString());
        } else {
            for (char c : map[digits.charAt(index) - '0'].toCharArray()) {
                sb.append(c);
                dfs(digits, index + 1, sb, combinations);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String digits = "8";
        List<String> combinations = letterCombinations2(digits);
    }
}
