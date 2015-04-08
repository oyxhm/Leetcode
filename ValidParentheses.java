/* 
* @Author: yhf
* @Date:   2015-04-08 12:28:34
* @Last Modified by:   yhf
* @Last Modified time: 2015-04-08 13:14:01
*/

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

import java.util.*;

public class ValidParentheses {
	public static boolean isValidParentheses(String s) {
		Stack<Character> st = new Stack<Character>();

		HashMap<Character, Character> map = new HashMap<Character, Character>();
			map.put('(', ')');
			map.put('{', '}');
			map.put('[', ']');

		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				st.push(c);
			} else if (st.isEmpty() || map.get(st.pop()) != c){
				return false;
			}
		}
		return st.isEmpty();
	}

    public static void main(String[] args) {
    	System.out.println(isValidParentheses("("));
    	System.out.println(isValidParentheses("(}"));
    	System.out.println(isValidParentheses("()"));
    	System.out.println(isValidParentheses("())"));
    	System.out.println(isValidParentheses("(]]]"));
    }
}