import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yhf on 15/6/16.
 */

/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true

the second char of pattern is "*"
the second char of pattern is not "*"
For the 1st case, if the first char of pattern is not ".", the first char of pattern and string should be the same.
Then continue to match the remaining part.

For the 2nd case, if the first char of pattern is "." or first char of pattern == the first i char of string, continue
to match the remaining part.
*/

class Graph {
    private int V;
    private List<Integer>[] adj;
    private boolean[] visited;

    public Graph(int V) {
        this.V = V;
        adj = (List<Integer>[]) new List[V];
        visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public int V() {
        return this.V;
    }

    public List<Integer> adj(int v) {
        return adj[v];
    }

    public boolean visited(int v) {
        return visited[v];
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void dfs(int v) {
        visited[v] = true;
        for (int w : adj[v]) {
            if (!visited[w]) {
                dfs(w);
            }
        }
    }

    public void reset() {
        visited = new boolean[V];
    }
}


public class RegularExpressionMatching {
    private int M;
    private Graph G;

    public Graph buildEpsilonTransitionGraph(String p) {
        // add Epsilon-Transition edges
        this.M = p.length();
        Graph G = new Graph(M + 1);
        Stack<Integer> ops = new Stack<>();
        for (int i = 0; i < p.length(); i++) {
            int lp = i;      // left parentheses

            if (p.charAt(i) == '(' || p.charAt(i) == '|') {
                ops.push(i);
            } else if (p.charAt(i) == ')') {
                lp = ops.pop();
                if (p.charAt(lp) == '|') {
                    int or = lp;
                    lp = ops.pop();
                    G.addEdge(lp, or + 1);
                    G.addEdge(or, i);
                }
            }

            if (p.charAt(i) == '(' || p.charAt(i) == ')' || p.charAt(i) == '*') {
                G.addEdge(i, i + 1);
            }

            if (i < M - 1 && p.charAt(i + 1) == '*') {   // build a closure
                G.addEdge(i, i + 1);
                G.addEdge(i + 1, i);
            }
        }

        return G;
    }


    public boolean isMatch(String s, String p) {
        G = buildEpsilonTransitionGraph(p);
        List<Integer> next = new ArrayList<>();

        G.dfs(0);
        for (int i = 0; i < G.V(); i++) {
            if (G.visited(i)) {
                next.add(i);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            List<Integer> match = new ArrayList<>();
            for (int v : next) {
                if (v < M && (p.charAt(v) == '.' || p.charAt(v) == s.charAt(i))) {
                    match.add(v + 1);
                }
            }

            G.reset();
            for (int m : match) {
                G.dfs(m);
            }
            next = new ArrayList<>();
            for (int v = 0; v < G.V(); v++) {
                if (G.visited(v)) {
                    next.add(v);
                }
            }
        }

        for (int v : next) {
            if (v == M) {
                return true;
            }
        }
        return false;
    }

    public boolean matchAll(String[] ss, String p) {
        for (String s : ss) {
            if (!isMatch(s, p)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RegularExpressionMatching r = new RegularExpressionMatching();
        assert !r.isMatch("aa", "a");
        assert r.isMatch("aa", "aa");
        assert !r.isMatch("aaa", "aa");
        assert r.isMatch("aaa", "a*");
        assert r.isMatch("aaa", ".*");
        assert r.isMatch("ab", ".*");
        assert r.isMatch("aab", "c*a*b");
        assert !r.isMatch("ab", ".*c");
        assert r.isMatch("aaa", "a*a");
        assert r.isMatch("a", "ab*c*");
        assert !r.isMatch("a", ".*..a*");
        assert !r.isMatch("a", ".*c.a*");
        assert r.isMatch("bbbba", ".*a*a");
        assert !r.isMatch("caabbaccbbacaabbbb", ".*b*.*a*aa*a*");

        assert r.matchAll(new String[]{"ac", "bc"}, "(a|b)c");
        assert r.matchAll(new String[]{"AABD", "ACD", "BD"}, "(A*B|AC)D");
        assert r.matchAll(new String[]{"waabc", "dg", "eefg"}, "(.*abc|(d|e*f)g)");
    }
}
