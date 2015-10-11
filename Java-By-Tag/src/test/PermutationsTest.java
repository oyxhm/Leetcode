package src.test;

import org.junit.Test;
import src.main.Permutations;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yhf on 10/11/15.
 */
public class PermutationsTest {

    @Test
    public void testPermute() throws Exception {
        Permutations s = new Permutations();
        List<List<Integer>> res = s.permute(new int[]{1, 2, 3});
    }
}
