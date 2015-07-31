import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhf on 15/5/24.
 */

/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }
        int m = matrix.length, n = matrix[0].length;

        int x = 0, y = 0;

        while (m > 0 && n > 0) {
            if (m == 1) {
                for (int j = 0; j < n; j++) {
                    res.add(matrix[x][y++]);
                }
                return res;
            }
            if (n == 1) {
                for (int i = 0; i < m; i++) {
                    res.add(matrix[x++][y]);
                }
                return res;
            }

            // left to right
            for (int j = 0; j < n - 1; j++) {  // 注意是 n - 1
                res.add(matrix[x][y++]);
            }
            // top to bottom
            for (int i = 0; i < m - 1; i++) {
                res.add(matrix[x++][y]);
            }
            // right to left
            for (int j = n - 1; j > 0; j--) {
                res.add(matrix[x][y--]);
            }
            // bottom to top
            for (int i = m - 1; i > 0; i--) {
                res.add(matrix[x--][y]);
            }

            m -= 2;
            n -= 2;
            x++;   // 这里要注意，因为是往里一圈
            y++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> res = spiralOrder(matrix);
    }
}
