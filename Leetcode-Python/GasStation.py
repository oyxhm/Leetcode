"""
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next
station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.

1) global_left = sum(gas[i] - cost[i]), it is the total gas left after a round.
   if global_left < 0, means it cannot complete a circuit, returns -1.
2) suppose (i, j] is an interval where you cannot get from i to j. Then any k that i < k <= j
   cannot be a start point. Because if k is a start point, you must can get from k to j, which
   means sum(k to j) >= 0, then sum(from i to k) < 0, then you should be stop at k rather than j.
3) So, if you stop at j, update the start point at j + 1.
4) If no point in [0, len-1) is start point, then the last one must be. Because global_left >= 0,
   then there must be a start point.
5) We can optimize our solution in one-pass.
"""


class Solution:
    # @param {integer[]} gas
    # @param {integer[]} cost
    # @return {integer}
    def canCompleteCircuit(self, gas, cost):
        gas_left = global_left = 0
        start = 0
        for idx, (g, c) in enumerate(zip(gas, cost)):
            gas_left += g - c
            global_left += g - c
            if gas_left < 0:
                start = idx + 1
                gas_left = 0
        return start if global_left >= 0 else -1
