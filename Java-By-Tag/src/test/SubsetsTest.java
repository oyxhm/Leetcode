package src.test;

import org.junit.Test;
import src.main.Subsets;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yhf on 10/11/15.
 */
public class SubsetsTest {

    @Test
    public void testSubsets() throws Exception {
        Subsets s = new Subsets();
        List<List<Integer>> res = s.subsets(new int[]{1, 2, 3});
        List<List<Integer>> res2 = s.subsets(new int[]{});
    }
}