/**
 * Created by yhf on 15/4/17.
 */

/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/

public class AddBinary {
    public static String addBinary(String a, String b) {
        int lenA = a.length(), lenB = b.length();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = lenA - 1, j = lenB - 1; i >= 0 || j >= 0; i--, j--) {
            int x = i < 0 ? 0 : Integer.parseInt(""+a.charAt(i));
            int y = j < 0 ? 0 : Integer.parseInt(""+b.charAt(j));
            int sum = x + y + carry;
            carry = sum / 2;
            sum %= 2;
            sb.append(sum);
        }
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a, b));
    }
}
