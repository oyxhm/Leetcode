/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/

import java.util.*;

public class ClimbingStairs {
	public static int climbingStairs(int n) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(0);
		l.add(1);
		l.add(2);
		if (n <= 2) {
			return l.get(n);
		}
		for (int i = 3; i <= n; i++) {
			l.add(l.get(i-2) + l.get(i-1));
		}
		return l.get(n);
	}

	public static void main(String[] args) {
		System.out.println(climbingStairs(1));
		System.out.println(climbingStairs(2));
		System.out.println(climbingStairs(3));
		System.out.println(climbingStairs(4));
		System.out.println(climbingStairs(10));
	}
}
