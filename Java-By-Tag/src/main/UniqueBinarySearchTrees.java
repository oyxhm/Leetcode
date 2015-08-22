package src.main;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yhf on 8/22/15.
 */

/*
* Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
*
* For example,
* Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

public class UniqueBinarySearchTrees {

    @Deprecated
    public int numTrees2(int n) {
        // Time Limit Exceeded
        if (n <= 0) {
            return 1;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += numTrees2(i - 1) * numTrees2(n - i);
        }
        return sum;
    }

    private Map<Integer, Integer> res = new HashMap<>();

    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (!res.containsKey(i - 1)) {
                res.put(i - 1, numTrees(i - 1));
            }
            int numLeft = res.get(i - 1);
            if (!res.containsKey(n - i)) {
                res.put(n - i, numTrees(n - i));
            }
            int numRight = res.get(n - i);
            sum += numLeft * numRight;
        }
        return sum;
    }
}

