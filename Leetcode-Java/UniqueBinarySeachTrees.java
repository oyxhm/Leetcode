import java.util.HashMap;
import java.util.Map;

/**
 * Created by yhf on 8/5/15.
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

public class UniqueBinarySeachTrees {
    private static Map<Integer, Integer> nums = new HashMap<>();

    public static int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int num = 0;
        for (int i = 1; i <= n; i++) {
            int num1, num2;
            if (nums.get(i - 1) == null) {
                num1 = numTrees(i - 1);
                nums.put(i - 1, num1);
            } else {
                num1 = nums.get(i - 1);
            }
            if (nums.get(n - i) == null) {
                num2 = numTrees(n - i);
                nums.put(n - i, num2);
            } else {
                num2 = nums.get(n - i);
            }
            num += num1 * num2;
        }
        return num;
    }

    public static void main(String[] args) {
        int count = numTrees(3);
    }
}
