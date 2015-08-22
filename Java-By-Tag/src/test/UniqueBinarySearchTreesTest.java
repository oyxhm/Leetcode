package src.test;

import org.junit.Test;

import src.main.UniqueBinarySearchTrees;

/**
 * Created by yhf on 8/22/15.
 */
public class UniqueBinarySearchTreesTest {

    @Test
    public void testNumTrees2() throws Exception {
        UniqueBinarySearchTrees s = new UniqueBinarySearchTrees();
        assert s.numTrees(1) == 1;
        assert s.numTrees(3) == 5;
    }

    @Test
    public void testNumTrees() throws Exception {
        UniqueBinarySearchTrees s = new UniqueBinarySearchTrees();
        assert s.numTrees(1) == 1;
        assert s.numTrees(3) == 5;
    }
}