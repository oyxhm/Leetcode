import java.util.*;

/**
 * Created by yhf on 15/6/11.
 */

/*
Given an array of integers, find out whether there are two distinct indices i and j in the array such that the difference
between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
*/

public class ContainsDuplicate3 {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (set.ceiling(val) != null && set.ceiling(val) <= t + val ||
                    set.floor(val) != null && val <= t + set.floor(val)) {
                // 一定要用这种，不能
                /*if (set.ceiling(val) != null && set.ceiling(val) - val <= t ||
                    set.floor(val) != null && val - set.floor(val) <= t) */
                // 这样{-1, 2147483647}, 1, 2147483647)时会溢出
                return true;
            }
            set.add(val);
            /*if (set.contains(i - k)) {
                set.remove(nums[i - k]);
            }*/  // 不要用这段，复杂度为log(n)
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyAlmostDuplicate(new int[]{-1, 2147483647}, 1, 2147483647));
    }
}
