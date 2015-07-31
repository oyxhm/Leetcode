/**
 * Created by yhf on 15/5/26.
 */

/*
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.

https://leetcodenotes.wordpress.com/2013/10/20/leetcode-multiply-strings-%E5%A4%A7%E6%95%B4%E6%95%B0%E7%9A%84%E5%AD%97%E7%AC%A6%E4%B8%B2%E4%B9%98%E6%B3%95/comment-page-1/#comment-122

直接乘会溢出，所以每次都要两个single digit相乘，最大81，不会溢出。
比如385 * 97, 就是个位=5 * 7，十位=8 * 7 + 5 * 9 ，百位=3 * 7 + 8 * 9 …
可以每一位用一个int表示，存在一个int[]里面。
这个数组最大长度是num1.len + num2.len，比如99 * 99，最大不会超过10000，所以4位就够了。
*/

public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        int[] num = new int[num1.length() + num2.length()];
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        for (int i = 0; i < num1.length(); i++) {
            int digit1 = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int digit2 = num2.charAt(j) - '0';
                num[i + j] += digit1 * digit2;    // 这里是+=，注意不要写成=
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length - 1; i++) {
            sb.insert(0, num[i] % 10);
            num[i + 1] += num[i] / 10;
        }
        sb.insert(0, num[num.length - 1]);
        while (sb.length() > 0 && sb.charAt(0) == '0') { // trim starting '0'
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String s = multiply("12", "123");
    }
}
