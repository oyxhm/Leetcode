package src.test;

import org.junit.Test;

import src.main.ClimbingStairs;

/**
 * Created by yhf on 8/22/15.
 */
public class ClimbingStairsTest {

    @Test
    public void testClimbStairs() throws Exception {
        ClimbingStairs s = new ClimbingStairs();
        assert s.climbStairs(3) == 4;
    }
}