"""
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell
one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you
must sell the stock before you buy again).
"""

class Solution:
    # @param {integer[]} prices
    # @return {integer}
    def maxProfit(self, prices):
        max_profit = 0
        for idx, price in enumerate(prices):
            if idx > 0 and price > prices[idx - 1]:
                max_profit += price - prices[idx - 1]
        return max_profit


if __name__ == '__main__':
    assert Solution().maxProfit([1, 2, 3, 1, 4]) == 5
