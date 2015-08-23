package src.test;

import org.junit.Test;
import src.main.UniquePaths2;

import static org.junit.Assert.*;

/**
 * Created by yhf on 8/23/15.
 */
public class UniquePaths2Test {

    @Test
    public void testUniquePathsWithObstacles() throws Exception {
        int obstacleGrid[][] = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        UniquePaths2 s = new UniquePaths2();
        assert s.uniquePathsWithObstacles(obstacleGrid) == 2;
    }
}