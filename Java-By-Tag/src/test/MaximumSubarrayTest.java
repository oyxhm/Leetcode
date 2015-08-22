package src.test;

import org.junit.Test;
import src.main.MaximumSubarray;

/**
 * Created by yhf on 8/22/15.
 */
public class MaximumSubarrayTest {

    @Test
    public void testMaxSubArray() throws Exception {
        MaximumSubarray s = new MaximumSubarray();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assert s.maxSubArray(nums) == 6;
        assert s.maxSubArray2(nums) == 6;
    }
}