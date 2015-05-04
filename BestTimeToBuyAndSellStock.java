/**
 * Created by yhf on 15/5/4.
 */

/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell
one share of the stock), design an algorithm to find the maximum profit.
*/

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = Math.max(prices[1] - prices[0], 0);
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i - 1]);
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {4, 2, 1, 8, 10, 7, 4};
        int maxProfit = maxProfit(prices);
    }
}
