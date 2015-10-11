package src.main;

/**
 * Created by yhf on 10/11/15.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of numbers, return all possible permutations.
 *
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        // DFS
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> first = new ArrayList<>();
        for (int num : nums) {
            first.add(num);
        }
        res.add(first);

        permute(nums, 0, res);
        return res;
    }

    private void permute(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length - 1) {
            return;
        }
        int size = res.size();
        for (int i = index + 1; i < nums.length; i++) {
            for (int j = 0; j < size; j++) {
                List<Integer> cur = new ArrayList<>(res.get(j));
                swap(cur, index, i);
                res.add(cur);
            }
        }
        permute(nums, index + 1, res);
    }

    public List<List<Integer>> permute2(int[] nums) {
        // BFS
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> first = new ArrayList<>();
        for (int num : nums) {
            first.add(num);
        }
        res.add(first);

        for (int i = 0; i < nums.length - 1; i++) {
            int size = res.size();
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = 0; k < size; k++) {
                    List<Integer> cur = new ArrayList<>(res.get(k));
                    swap(cur, i, j);
                    res.add(cur);
                }
            }
        }
        return res;
    }

    private void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
