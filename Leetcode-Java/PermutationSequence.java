import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhf on 15/5/24.
 */

/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.


For example, assuming we are going to solve the problem when n = 3 and k = 5.
In fact, because k starts from 1, we need to subtract 1 from it to make it starting from 0. So we are going to find the permutation 4 now.
To calculate the first digit, we can calculate it by k % (n – 1)! = 4 / 2! = 2, which is the position of 3 in array [1,2,3].
Now we need to delete 3 from the array, so the array becomes [1, 2]. And k should become 4 % 2! = 0.
Now we calculate k / (n – 2)! = 0 / 1 = 0, which is the position of 1 in array [1, 2]. So the second digit should be 1.
We need to delete 1 from the array. And there is only one entry left in the array. So the final digit should be 2.
Finally we get the permutation: 312.
*/

public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int fac = 1;
        for (int i = 1; i <= n; i++) {  // 1, 2, 3, 4, ..., n
            fac *= i;
            nums.add(i);
        }

        StringBuilder sb = new StringBuilder();
        k--;
        for (int i = n; i >= 1; i--) {
            fac /= i;
            int idx = k / fac;   // idx at nums
            k %= fac;
            sb.append(nums.get(idx));
            nums.remove(idx);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String res = getPermutation(3, 5);
    }
}
