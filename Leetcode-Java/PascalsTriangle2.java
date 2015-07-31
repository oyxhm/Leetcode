/**
 * Created by yhf on 15/4/14.
 */

/*
Given an index k, return the kth row of the Pascal's triangle.
For example, given k = 3,
Return [1,3,3,1].

    [
           [1],
          [1,1],
         [1,2,1],
        [1,3,3,1],
       [1,4,6,4,1]
    ]

*/

import java.util.*;

public class PascalsTriangle2 {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        for (int row = 0; row < rowIndex + 1; row++) {
            for (int col = row - 1; col > 0; col--) {
                l.set(col, l.get(col-1) + l.get(col));
            }
            if (row > 0) {
                l.add(1);
            }
        }
        return l;
    }

    public static void main(String[] args) {
        List<Integer> l = getRow(1);
        int a = 0;
    }


}
