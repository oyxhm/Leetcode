/**
 * Created by yhf on 15/4/13.
 */

/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

import java.util.*;

public class EvaluateReversePolishNotation {
    public static int evaluateReversePolishNotation(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int opr2 = s.pop();
                int opr1 = s.pop();
                switch (token) {
                    case "+": s.push(opr1 + opr2); break;
                    case "-": s.push(opr1 - opr2); break;
                    case "*": s.push(opr1 * opr2); break;
                    case "/": s.push(opr1 / opr2); break;
                }
            } else {
                s.push(Integer.valueOf(token));
            }
        }
        return s.pop();
    }

    public static void main(String[] args) {
        // String[] tokens = {"2", "1", "+", "3", "*"};
        String[] tokens = {"0", "3", "/"};
        System.out.println(evaluateReversePolishNotation(tokens));
    }
}
