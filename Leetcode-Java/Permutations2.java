import java.util.*;

/**
 * Created by yhf on 15/5/26.
 */

/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/

public class Permutations2 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        permuteUnique5(nums, used, cur, res);
        return res;
    }

    private static void permuteUnique(int[] nums, int idx, List<List<Integer>> res, Set<List<Integer>> set) {
        // Time Limit Exceeded
        if (idx == nums.length) {
            List<Integer> l = new ArrayList<>();
            for (int num : nums) {
                l.add(num);
            }
            if (!set.contains(l)) {
                res.add(l);
                set.add(l);
            }
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            permuteUnique(nums, idx + 1, res, set);
            swap(nums, idx, i);
        }
    }

    private static void permuteUnique2(int[] nums, int idx, List<List<Integer>> res) {
        if (idx == nums.length) {
            List<Integer> l = new ArrayList<>();
            for (int num : nums) {
                l.add(num);
            }
            res.add(l);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            //  idx, x, i-1, i，假设 nums[x] = nums[i]
            // 如果 idx 到 i-1 之间(inclusive)存在某点跟i相同的话，就没必要dfs下去了。
            // 因为之后 x, idx, i-1, i 的时候会dfs。这样就避免重复的res
            if (!containDuplicate(nums, idx, i)) {
                swap(nums, idx, i);
                permuteUnique2(nums, idx + 1, res);
                swap(nums, idx, i);
            }
        }
    }

    private static boolean containDuplicate(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] == nums[end]) {
                return true;
            }
        }
        return false;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static List<List<Integer>> permuteUnique3(int[] nums) {
        // BFS, Time Limit Exceeded
        // 在Permutation之后再加个Set
        List<List<Integer>> res = new ArrayList<>();
        Queue<List<Integer>> cur = new LinkedList<>();
        if (nums.length == 0) {
            return res;
        }
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> l = new ArrayList<>();
        l.add(nums[0]);
        cur.add(l);
        for (int i = 1; i < nums.length; i++) {
            int size = cur.size();
            for (int j = 0; j < size; j++) {
                List<Integer> temp = cur.remove();
                for (int idx = 0; idx <= temp.size(); idx++) {
                    List<Integer> newTemp = new ArrayList<>(temp);
                    newTemp.add(idx, nums[i]);
                    cur.add(newTemp);
                }
            }
        }
        while (!cur.isEmpty()) {
            List<Integer> temp = cur.remove();
            set.add(temp);
        }
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> permuteUnique4(int[] nums) {
        // BFS, Accepted
        List<List<Integer>> returnList = new ArrayList<>();
        returnList.add(new ArrayList<Integer>());

        for (int i = 0; i < nums.length; i++) {
            Set<List<Integer>> curSet = new HashSet<>();
            for (List<Integer> l : returnList) {
                for (int j = 0; j < l.size() + 1; j++) {
                    l.add(j, nums[i]);
                    ArrayList<Integer> T = new ArrayList<Integer>(l);
                    l.remove(j);
                    curSet.add(T);
                }
            }
            returnList = new ArrayList<>(curSet);
        }

        return returnList;
    }

    public static void permuteUnique5(int[] nums, boolean[] used, List<Integer> cur, List<List<Integer>> res) {
        // DFS, 用这种
        // http://blog.csdn.net/linhuanmars/article/details/21570835
        if (cur.size() == nums.length) {
            List<Integer> l = new ArrayList<>(cur);
            res.add(l);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            if (!used[i]) {
                cur.add(nums[i]);
                used[i] = true;
                permuteUnique5(nums, used, cur, res);
                cur.remove(cur.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = permuteUnique4(new int[]{-1, -1, 3, -1});
    }
}
