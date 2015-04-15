/**
 * Created by yhf on 15/4/15.
 */

/*

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
money you can rob tonight without alerting the police.
*/

public class HouseRobber {
    public static int rob(int[] num) {
        // O(n) runtime, O(n) space
        int len = num.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return num[0];
        }
        int[] dp = new int[len];
        dp[0] = num[0];
        dp[1] = Math.max(num[0], num[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i-2] + num[i], dp[i-1]);
        }
        return dp[len-1];
    }

    public static int rob2(int[] num) {
        // O(n) runtime, O(1) space
        // 只需记录之前的两个状态就够了
        int len = num.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return num[0];
        }
        int even = num[0];
        int odd = Math.max(num[0], num[1]);
        for (int i = 2; i < len; i++) {
            if (i % 2 == 0) {
                even = Math.max(even + num[i], odd);
            } else {
                odd = Math.max(odd + num[i], even);
            }
        }
        return len % 2 == 0? odd : even;
    }

    public static void main(String[] args) {
        int[] num = {1, 3, 5, 4, 2, 6, 7};
        System.out.println(rob(num));
    }
}
