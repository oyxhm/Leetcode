import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhf on 15/4/30.
 */

/*
Description:

Count the number of prime numbers less than a non-negative number, n.
*/

public class CountPrimes {
    public static int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        for (int i = 3; i < n; i += 2) {   // 注意，步进为2
            int sqrtI = (int) Math.sqrt(i);
            for (int j = 0; i % primes.get(j) != 0; j++) {
                if (primes.get(j) > sqrtI) {
                    primes.add(i);
                    break;
                }
            }
        }
        return primes.size();
    }

    public static void main(String[] args) {
        int i = countPrimes(499979);
    }
}
