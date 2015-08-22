package src.test;

import org.junit.Test;
import src.main.BestTimeToBuyAndSellStock;

import static org.junit.Assert.*;

/**
 * Created by yhf on 8/22/15.
 */
public class BestTimeToBuyAndSellStockTest {

    @Test
    public void testMaxProfit() throws Exception {
        int[] prices = new int[]{1, 2, 5, 0, 2, 4, 8, -3, 4};
        BestTimeToBuyAndSellStock s = new BestTimeToBuyAndSellStock();
        assert s.maxProfit(prices) == 8;
        assert s.maxProfit(new int[] {}) == 0;
        assert s.maxProfit(new int[] {5}) == 0;
    }
}