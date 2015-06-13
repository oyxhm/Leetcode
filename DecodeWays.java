import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by yhf on 15/6/13.
 */

/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/

public class DecodeWays {
    public static int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int[] nums = new int[s.length()];
        nums[0] = 1;
        if (canBeDecoded(s.substring(1, 2))) {
            nums[1] = canBeDecoded(s.substring(0, 2)) ? 2 : 1;
        } else {
            nums[1] = canBeDecoded((s.substring(0, 2))) ? 1 : 0;
        }

        for (int i = 2; i < s.length(); i++) {
            if (canBeDecoded(s.substring(i - 1, i + 1))) {
                nums[i] += nums[i - 2];
            }
            if (canBeDecoded(s.substring(i, i + 1))) {
                nums[i] += nums[i - 1];
            }
        }
        return nums[s.length() - 1];
    }

    private static Boolean canBeDecoded(String s) {
        return s.charAt(0) != '0' && Integer.parseInt(s) <= 26;
    }

    public static void main(String[] args) {
        int num = numDecodings("10");
    }
}
