import java.util.Arrays;

/**
 * Created by yhf on 15/5/9.
 */

/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.


*/

public class LargestNumber {
    public static String largestNumber(int[] nums) {
        int len = nums.length;
        String[] strNums = new String[len];
        for (int i = 0; i < len; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (compare(strNums[i], strNums[j])) {
                    String temp = strNums[i];
                    strNums[i] = strNums[j];
                    strNums[j] = temp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            sb.append(strNums[i]);
        }
        int index = 0;
        while (index < sb.length() - 1 && sb.charAt(index) == '0') {
            index++;
        }
        return sb.substring(index);
    }

    public static boolean compare(String s1, String s2) {
        return (s1 + s2).compareTo(s2 + s1) > 0? Boolean.TRUE : Boolean.FALSE;
    }

    public static void main(String[] args) {
        String num = largestNumber(new int[] {0});
    }
}
