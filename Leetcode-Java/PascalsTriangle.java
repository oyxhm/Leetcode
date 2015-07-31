import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by yhf on 15/4/14.
 */

/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return
    [
           [1],
          [1,1],
         [1,2,1],
        [1,3,3,1],
       [1,4,6,4,1]
    ]
*/

import java.util.*;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        for (int row = 0; row < numRows; row++) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            for (int i = 1; i < row; i++) {
                int num = l.get(row-1).get(i-1) + l.get(row-1).get(i);
                temp.add(num);
            }
            if (row > 0) {
                temp.add(1);
            }
            l.add(temp);
        }
        return l;
    }

    public static void main(String[] args) {
        List<List<Integer>> l = generate(5);
        int a = 0;
    }
}
