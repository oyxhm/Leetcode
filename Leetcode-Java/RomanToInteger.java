import java.util.HashMap;
import java.util.Map;

/**
 * Created by yhf on 15/5/19.
 */

/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/

public class RomanToInteger {
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int prev = 0, cur, num = 0;
        for (char c : s.toCharArray()) {
            cur = map.get(c);
            num += cur > prev ? (cur - 2 * prev) : cur;
            prev = cur;
        }
        return num;
    }

    public static void main(String[] args) {
        int num = romanToInt("VI");
        int num2 = romanToInt("IV");
    }
}
