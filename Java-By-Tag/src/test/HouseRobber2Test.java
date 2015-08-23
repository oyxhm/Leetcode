package src.test;

import org.junit.Test;
import src.main.HouseRobber2;

import static org.junit.Assert.*;

/**
 * Created by yhf on 8/23/15.
 */
public class HouseRobber2Test {

    @Test
    public void testRob() throws Exception {
        HouseRobber2 s = new HouseRobber2();
        assert s.rob(new int[]{1, 4, 3}) == 4;
        assert s.rob(new int[]{1, 2, 4, 3, 5, 2}) == 10;
    }
}