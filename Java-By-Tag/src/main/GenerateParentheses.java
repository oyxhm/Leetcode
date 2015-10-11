package src.main;

/**
 * Created by yhf on 10/10/15.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        generateParenthesis(n, 0, "", res);
        return res;
    }

    private void generateParenthesis(int n, int numLeft, String cur, List<String> res) {
        if (cur.length() == 2 * n) {
            if (numLeft == n) {
                res.add(cur);
            }
            return;
        }
        if (numLeft > cur.length() - numLeft) {
            generateParenthesis(n, numLeft, cur + ')', res);
        }
        generateParenthesis(n, numLeft + 1, cur + '(', res);
    }
}
