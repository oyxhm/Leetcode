import java.util.HashMap;
import java.util.Map;

/**
 * Created by yhf on 15/5/25.
 */

/*
Given an array of integers, find if the array contains any duplicates. Your function should return true if
any value appears at least twice in the array, and it should return false if every element is distinct.
*/

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            } else {
                map.put(num, true);
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
