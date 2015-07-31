import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhf on 15/5/8.
 */

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        dfs("", n, 0, res);
        return res;
    }

    public static void dfs(String cur, int n, int numLeft, List<String> res) {
        // numLeft: number of '(' already generated
        if (cur.length() == n * 2) {  // a combination is generated
            res.add(cur);
            return;
        }

        if (numLeft < n) {   // there's '(' left
            dfs(cur + '(', n, numLeft + 1, res);
        }

        if (cur.length() < numLeft * 2) {  // if # ')' < # '('
            dfs(cur + ')', n, numLeft, res);
        }
    }

    public static List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<String>();
        StringBuilder cur = new StringBuilder();
        dfs(cur, n, 0, res);
        return res;
    }

    public static void dfs(StringBuilder cur, int n, int numLeft, List<String> res) {
        // numLeft: number of '(' already generated
        if (cur.length() == n * 2) {
            // a combination is generated
            String s = cur.toString();
            res.add(s);
            return;
        }

        if (numLeft < n) {
            // there's '(' left
            cur.append('(');
            dfs(cur, n, numLeft + 1, res);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (cur.length() < numLeft * 2) {
            // if # ')' < # '('
            cur.append(')');
            dfs(cur, n, numLeft, res);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
    }
}
