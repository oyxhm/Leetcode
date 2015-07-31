import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhf on 15/5/7.
 */

/*
Implement pow(x, n).
*/

public class Pow {
    public static double myPow(double x, int n) {
        if (Double.compare(x, 0.) == 0) {
            return 0.;
        }
        if (n < 0) {
            n *= -1;
            x = 1. / x;
        }
        double res = 1.;
        while (n > 0) {
            if (n % 2 == 1) {
                res *= x;
            }
            x *= x;
            n /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        double res1 = myPow(-2, -3);
        double res2 = myPow(2, -4);
        double res3 = myPow(0., -4);
        double res4 = myPow(3, 0);
    }
}
