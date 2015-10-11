package src.test;

import org.junit.Test;
import src.main.FourSum;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yhf on 9/25/15.
 */
public class FourSumTest {

    @Test
    public void testFourSum() throws Exception {
        int[] nums = new int[]{1, 2, 3, 3, 4, 5, 6};
        FourSum s = new FourSum();
        List<List<Integer>> res = s.fourSum(nums, 14);
    }
}