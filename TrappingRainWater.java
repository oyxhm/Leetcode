/**
 * Created by yhf on 15/6/22.
 */

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it
is able to trap after raining.

For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

关键是在于找到规律：
即第i块地方的存水量 = min(第i块左边最高的bar高度, 第i块右边最高的bar的高度) - 第i块地方bar的高度
例如图中，第5块地方的存水量 = min(2,3)-0 = 2
2为其左边最高的bar，即第3块地方的bar
3为其右边最高的bar，即第7块地方的bar，
0为其自身的bar高度
*/

public class TrappingRainWater {
    public static int trap(int[] height) {
        int len = height.length;
        if (len <= 2) {
            return 0;
        }
        int[] leftHighest = new int[len];    // max height left to bar i
        int[] rightHighest = new int[len];   // max height right to bar i
        for (int i = 1; i < len; i++) {
            leftHighest[i] = Math.max(leftHighest[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            rightHighest[i] = Math.max(rightHighest[i + 1], height[i + 1]);
        }

        int size = 0;
        for (int i = 1; i <= len - 2; i++) {
            size += Math.max(0, Math.min(leftHighest[i], rightHighest[i]) - height[i]);   // in case the water on this bar is negative
        }
        return size;
    }

    public static void main(String[] args) {
        assert trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}) == 6;
        assert trap(new int[]{2, 0, 2}) == 2;
    }
}
