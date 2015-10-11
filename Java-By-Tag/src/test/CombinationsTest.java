package src.test;

import org.junit.Test;
import src.main.Combinations;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yhf on 10/11/15.
 */
public class CombinationsTest {

    @Test
    public void testCombine() throws Exception {
        Combinations s = new Combinations();
        List<List<Integer>> res = s.combine(4, 2);
    }
}