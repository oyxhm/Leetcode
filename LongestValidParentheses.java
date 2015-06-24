import java.util.Stack;

/**
 * Created by yhf on 15/6/24.
 */

/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/

public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        int pre = -1;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.empty()) {
                    stack.pop();
                    if (stack.empty()) {
                        max = Math.max(i - pre, max);
                    } else {
                        max = Math.max(i - stack.peek(), max);
                    }
                } else {  // stack is empty
                    pre = i;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int len = longestValidParentheses(")()())");
        int len2 = longestValidParentheses("(()");
        int len3 = longestValidParentheses(")()()()())(()())()()");
        int len4 = longestValidParentheses("()(())");
    }
}
