/**
 * Created by yhf on 15/4/22.
 */

/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
*/

/*
* 1） total = ∑ (gas[i] - cost[i]), 0 <= i < N;
*     如果total < 0，说明根本不可能绕一圈，返回-1；
*     如果total >= 0，说明至少存在一个start的点。
* 2） 计从start开始的 sum = ∑(gas-cost)，一旦sum<0，
*     就跳到下一个start，并将sum清零
* 3） 如果 i 到 j 不是一个解，那么start肯定不在 (i, j]。
*     因为如果假设k是一个满足条件的start，且 i < k <= j，
*     那么k到j的sum>0，那么i到k的sum<0，在k就应该停止了
* 4） 从2），3）知，由跳到下一个start时，直接跳到j+1即可。
* 5） 因为如果total>=0，start点肯定存在。当j到达N-1时，
*     因为已经证明此时的i之前的点都不是start点，
*     所以这时的i就是start点。由于start点唯一，所以循环结束。
* */

public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int total = 0, sum = 0, start = 0;
        for (int i = 0; i < len; i++) {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        return total >= 0? start : -1;
    }

    public static void main(String[] args) {
        int[] gas = {2, 4};
        int[] cost = {3, 4};
        int start = canCompleteCircuit(gas, cost);
    }
}
