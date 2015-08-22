package src.test;

import org.junit.Test;
import src.main.MinimumPathSum;

import static org.junit.Assert.*;

/**
 * Created by yhf on 8/22/15.
 */
public class MinimumPathSumTest {

    @Test
    public void testMinPathSum() throws Exception {
        int[][] grid = new int[][] {
                {1, 2, 3},
                {3, 8, 5},
                {2, 1, 6}
        };
        MinimumPathSum s = new MinimumPathSum();
        assert s.minPathSum(grid) == 13;
    }
}