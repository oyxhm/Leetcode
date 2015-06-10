/**
 * Created by yhf on 15/6/10.
 */

/*
Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
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
        int a = divide(1, -1);
    }
}
