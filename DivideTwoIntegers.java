/**
 * Created by yhf on 15/6/10.
 */

/*
Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.

Shift can be used to solve this problem. We shift the divisor left until it just smaller than
dividend but if we keep shifting one more bit, it’s larger than dividend. Than we can add the
shifted value to the result and subtract the shifted value from dividend. Keep doing this until
dividend is smaller than divisor. In fact, every integer can be represented by a set of base 2
so that shifting can be used.

http://www.lifeincode.net/programming/leetcode-divide-two-integers-java/
*/

public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        long longDivident = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);
        long subtractor = longDivisor;
        int numShift = 0;
        while (subtractor <= longDivident) {
            subtractor <<= 1;
            numShift++;
        }
        subtractor >>= 1;
        numShift--;
        int res = 0;
        while (true) {
            while (longDivident < subtractor) {
                numShift--;
                subtractor >>= 1;
            }
            if (numShift < 0) {
                return (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) ? res : -res;
            }
            res += 1 << numShift;
            longDivident -= subtractor;
        }
    }

    public static void main(String[] args) {
        int res = divide(1, -1);
    }
}
