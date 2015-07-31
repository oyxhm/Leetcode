import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yhf on 15/6/30.
 */

/*
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers
and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
Note: Do not use the eval built-in library function.
*/

public class BasicCalculator {
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int num = c - '0';
                int j = i + 1;
                while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    num = num * 10 + s.charAt(j) - '0';
                    j++;
                }
                res += stack.pop() * num;
                i = j - 1;
            } else if (c == '(' || c == '+') {
                stack.push(stack.peek());
            } else if (c == '-') {
                stack.push(-1 * stack.peek());
            } else if (c == ')') {
                stack.pop();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = calculate("(1+(4+5+2)-3)+(6+8)");
    }
}
