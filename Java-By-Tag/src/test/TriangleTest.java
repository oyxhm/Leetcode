package src.test;

import org.junit.Test;
import src.main.Triangle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yhf on 8/23/15.
 */
public class TriangleTest {

    @Test
    public void testMinimumTotal() throws Exception {
        List<Integer> row1 = new ArrayList<Integer>() {{
            add(2);
        }};
        List<Integer> row2 = new ArrayList<Integer>() {{
            add(3);
            add(4);
        }};
        List<Integer> row3 = new ArrayList<Integer>() {{
            add(6);
            add(5);
            add(7);
        }};
        List<Integer> row4 = new ArrayList<Integer>() {{
            add(4);
            add(1);
            add(8);
            add(3);
        }};
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(row1);
        triangle.add(row2);
        triangle.add(row3);
        triangle.add(row4);

        Triangle s = new Triangle();
        assert s.minimumTotal(triangle) == 11;
    }
}