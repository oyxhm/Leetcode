package src.test;

import org.junit.Test;
import src.main.EditDistance;

import static org.junit.Assert.*;

/**
 * Created by yhf on 8/23/15.
 */
public class EditDistanceTest {

    @Test
    public void testMinDistance() throws Exception {
        EditDistance s = new EditDistance();
        assert s.minDistance("abcd", "bda") == 3;
    }
}