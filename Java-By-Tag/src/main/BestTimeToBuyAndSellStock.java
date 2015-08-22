package src.main;

/**
 * Created by yhf on 8/22/15.
 */

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design
 * an algorithm to find the maximum profit.
 * */

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = Math.max(prices[1] - prices[0], 0);
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(prices[i - 1], minPrice);
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
        }
        return maxProfit;
    }
}
