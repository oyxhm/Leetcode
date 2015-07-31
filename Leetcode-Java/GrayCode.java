import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhf on 15/5/18.
 */

/*
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the
sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.

[0]
[0, 1]
[0, 1, 11, 10]
[00, 01, 11, 10, 110, 111, 101, 100]
*/

public class GrayCode {
    public static List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }
        List<Integer> res = grayCode(n - 1);
        int size = res.size();
        for (int i = size - 1; i >= 0; i--) {
            res.add(res.get(i) + (1 << (n - 1)));  // 注意加括号，运算优先级
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = grayCode(3);
    }
}
