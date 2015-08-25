package src.test;

import org.junit.Test;
import src.main.ScrambleString;

import static org.junit.Assert.*;

/**
 * Created by yhf on 8/24/15.
 */
public class ScrambleStringTest {

    @Test
    public void testIsScramble() throws Exception {
        ScrambleString s = new ScrambleString();
        assert s.isScramble("great", "rgeat");
        assert s.isScramble("great", "rgtae");
    }
}