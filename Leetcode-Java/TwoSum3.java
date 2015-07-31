/*
Design and implement a TwoSum class. It should support the following operations: add and find.
add(input) – Add the number input to an internal data structure.
find(value) – Find if there exists any pair of numbers which sum is equal to the value.
For example,
add(1); add(3); add(5); find(4)->true; find(7)->false
*/

import java.util.*;

class TwoSum3 {
    // add: O(1) runtime 
    // find: O(n) runtime
    // O(n) space   

    private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public static void add(int input) {
        int count = map.containsKey(input)? map.get(input) : 0;
        map.put(input, count + 1);
    }

    public static boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int remainder = value - num;
            if (remainder == num) {
                if (entry.getValue() > 2) {
                    return true;
                }
            } else {
                if (map.containsKey(value - num)) {
                    return true;
                }
            }
        } // end for
        return false;
    }

    public static void main(String[] args) {
        TwoSum3 twosum = new TwoSum3();
        twosum.add(1);
        twosum.add(3);
        twosum.add(5);
        System.out.println(twosum.find(4));
        System.out.println(twosum.find(7));
    }
}
