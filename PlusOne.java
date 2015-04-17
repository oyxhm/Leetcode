/**
 * Created by yhf on 15/4/17.
 */

/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/

import java.util.*;

public class PlusOne {
    public static List<Integer> plusOne(List<Integer> digits) {
        int len = digits.size(), i = len - 1, carry = 0;
        while (i >= 0) {
            int digit = i == len - 1 ? digits.get(i) + 1 + carry : digits.get(i) + carry;
            carry = digit / 10;
            digit = digit % 10;
            digit = digits.set(i--, digit);
        }
        if (carry == 1) {
            digits.add(0, 1);
        }
        return digits;
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>();
        l.add(9);
        l.add(9);
        l.add(9);
        List<Integer> result = plusOne(l);
        int i = 0;
    }
}
