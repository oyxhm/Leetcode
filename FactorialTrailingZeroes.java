/* 
* @Author: yhf
* @Date:   2015-04-11 10:44:58
* @Last Modified by:   yhf
* @Last Modified time: 2015-04-11 11:13:43
*/

/*
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
*/

import java.util.*;

public class FactorialTrailingZeroes {
	public static int factorialTrailingZeroes(int n) {
		List<Integer> l = new ArrayList<Integer>();
		int i = n, j;
		while (i > 0) {
			j = i % 5;
			i = i / 5;
			l.add(j);
		}
		int sum = 0, count = 0;
		for (int num : l) {
			sum += count * num;
			count = count * 5 + 1;
		}
		return sum;
	}

    public static void main(String[] args) {
    	System.out.println(factorialTrailingZeroes(4));
    	System.out.println(factorialTrailingZeroes(5));
    	System.out.println(factorialTrailingZeroes(6));
    	System.out.println(factorialTrailingZeroes(25));
    	System.out.println(factorialTrailingZeroes(24));
    	System.out.println(factorialTrailingZeroes(69));
    }
}
