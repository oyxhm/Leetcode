package src.test;

import org.junit.Test;
import src.main.GrayCode;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yhf on 10/10/15.
 */
public class GrayCodeTest {

    @Test
    public void testGrayCode() throws Exception {
        GrayCode s = new GrayCode();
        List<Integer> res = s.grayCode(2);
    }
}
