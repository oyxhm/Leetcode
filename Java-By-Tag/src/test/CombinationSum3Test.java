package src.test;

import org.junit.Test;
import src.main.CombinationSum3;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yhf on 10/11/15.
 */
public class CombinationSum3Test {

    @Test
    public void testCombinationSum3() throws Exception {
        CombinationSum3 s = new CombinationSum3();
        List<List<Integer>> res = s.combinationSum3(3, 7);
    }
}