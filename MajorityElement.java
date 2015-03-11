/* 
* @Author: yhf
* @Date:   2015-03-11 11:16:39
* @Last Modified by:   yhf
* @Last Modified time: 2015-03-11 11:21:27
*/

/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/

import java.util.*;

public class MajorityElement {
	public static int majorityElements(int[] num) {
		Arrays.sort(num);
		return num[num.length/2];
	}

    public static void main(String[] args) {
		int[] num = {1, 1, 1, 5, 5, 5, 5, 5, 5, 5, 3};
    	System.out.println(majorityElements(num));
    }
}
