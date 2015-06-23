"""
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an
algorithm to find the maximum profit.
"""


class Solution:
    # @param {integer[]} prices
    # @return {integer}
    def maxProfit(self, prices):
        min_price = 1 << 31
        max_profit = 0
        for price in prices:
            min_price = min(price, min_price)
            max_profit = max(max_profit, price - min_price)
        return max_profit


if __name__ == '__main__':
    assert Solution().maxProfit([3, 4, 5, 9, 1, 8, 5]) == 7
