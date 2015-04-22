import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yhf on 15/4/22.
 */

/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] num) {
        // 注意avoid duplicates一定要写在循环后面，
        // 因为写在前面，如 num = {0, 0, 0} 在一开始就会跳过去

        int len = num.length;
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (len < 3) {
            return ret;
        }
        Arrays.sort(num);
        for (int i = 0; i < len - 2; i++) {
            int target = 0 - num[i];
            for (int j = i + 1, k = len - 1; j < k; ) {
                int sum = num[j] + num[k];
                if (target == sum) {
                    ret.add(new ArrayList<Integer>(Arrays.asList(num[i], num[j++], num[k--])));

                    //avoid duplicates
                    while (j < k && num[j] == num[j-1]) {
                        j++;
                    }
                } else if (target < sum) {
                    k--;
                } else {
                    j++;
                }
            }

            // avoid duplicates
            while (i < len - 2 && num[i + 1] == num[i]) {
                i++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] num = {-2, 0, 0, 2, 2};
        List<List<Integer>> res = threeSum(num);
    }
}
