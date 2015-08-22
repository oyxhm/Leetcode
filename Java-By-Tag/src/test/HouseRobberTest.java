package src.test;

import org.junit.Test;
import src.main.HouseRobber;

import static org.junit.Assert.*;

/**
 * Created by yhf on 8/22/15.
 */
public class HouseRobberTest {

    @Test
    public void testRob() throws Exception {
        HouseRobber s = new HouseRobber();
        assert s.rob(new int[]{}) == 0;
        assert s.rob(new int[]{3}) == 3;
        assert s.rob(new int[]{3, 2, 5, 2, 9, 18}) == 26;
    }
}