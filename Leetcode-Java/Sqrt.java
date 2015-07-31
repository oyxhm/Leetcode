/**
 * Created by yhf on 15/5/24.
 */

/*
Implement int sqrt(int x).

Compute and return the square root of x.
*/

public class Sqrt {
    public static int mySqrt(int x) {
        // 注意int改为long，不然Time Limit Exceeded
        long left = 1;
        long right = x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;
            if (square == x) {
                return (int) mid;
            }
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) right;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.print(i);
            System.out.println(mySqrt(i));
        }
    }
}
