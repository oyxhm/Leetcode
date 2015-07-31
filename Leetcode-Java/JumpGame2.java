/**
 * Created by yhf on 15/5/25.
 */

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)


http://www.lifeincode.net/programming/leetcode-jump-game-and-jump-game-ii-java/

*/

public class JumpGame2 {
    public static int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int jumps = 1, steps = nums[0], maxReach = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {   // 注意i的范围
            maxReach = Math.max(maxReach, nums[i] + i);
            steps--;
            if (steps == 0) {   // steps用完了，step更新为当前点到maxReach的距离
                jumps++;
                steps = maxReach - i;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int min = jump(new int[]{2, 3, 1, 1, 4});
    }
}
