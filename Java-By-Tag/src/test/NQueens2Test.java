package src.test;

import org.junit.Test;
import src.main.NQueens2;

import static org.junit.Assert.*;

/**
 * Created by yhf on 10/10/15.
 */
public class NQueens2Test {

    @Test
    public void testTotalNQueens() throws Exception {
        NQueens2 s = new NQueens2();
        int count = s.totalNQueens(8);
    }
}
