package src.test;

import org.junit.Test;
import src.main.TreeNode;
import src.main.UniqueBinarySearchTrees2;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yhf on 8/23/15.
 */
public class UniqueBinarySearchTrees2Test {

    @Test
    public void testGenerateTrees() throws Exception {
        UniqueBinarySearchTrees2 s = new UniqueBinarySearchTrees2();
        List<TreeNode> roots = s.generateTrees(3);
    }
}