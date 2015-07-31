/**
 * Created by yhf on 15/5/25.
 */

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.   注意是maximum jump

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.


http://www.lifeincode.net/programming/leetcode-jump-game-and-jump-game-ii-java/

In Jump Game, we can save the farthest position we can reach when we go through the array.
Every time we move, we will decrease the step. When we updating it, the step remaining for us is also updated.
For example, for array A = [2, 3, 1, 1, 4], when we visit A[0], we update the maxReach to 2, and step to 2.
When we visit A[1], we update maxReach to 1 + 3 = 4. And step is updated to 3. We will continue doing this until
we reach the end or step getting to zero. If step getting to zero before we reach the end, it means that we can’t
move forward so that we should return false.
*/

public class JumpGame {
    public static boolean canJump(int[] nums) {
        int[] max = new int[nums.length];
        int localMax = nums[0], globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > globalMax) {
                return false;
            }
            localMax = i + nums[i];
            globalMax = Math.max(localMax, globalMax);
            if (globalMax >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{1, 2}));
    }
}
