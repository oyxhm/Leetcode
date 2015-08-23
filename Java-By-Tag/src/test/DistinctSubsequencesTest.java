package src.test;

import org.junit.Test;
import src.main.DistinctSubsequences;

import static org.junit.Assert.*;

/**
 * Created by yhf on 8/23/15.
 */
public class DistinctSubsequencesTest {

    @Test
    public void testNumDistinct() throws Exception {
        DistinctSubsequences s = new DistinctSubsequences();
        assert s.numDistinct("rabbbit", "rabbit") == 3;
    }
}