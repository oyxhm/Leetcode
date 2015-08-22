package src.test;

import org.junit.Test;
import src.main.UniquePaths;

import static org.junit.Assert.*;

/**
 * Created by yhf on 8/22/15.
 */
public class UniquePathsTest {

    @Test
    public void testUniquePaths() throws Exception {
        UniquePaths s = new UniquePaths();
        assert s.uniquePaths(3, 7) == 28;
    }
}