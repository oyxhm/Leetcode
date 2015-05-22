import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by yhf on 15/5/22.
 */

/*
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        dfs(nums, 0, res);
        return res;
    }

    public static void dfs(int[] nums, int idx, List<List<Integer>> res) {
        if (idx == nums.length) {
            List<Integer> l = new ArrayList<>();
            for (int num : nums) {
                l.add(num);
            }
            res.add(l);
            return;
        }

        for (int i = idx; i < nums.length; i++) {  // 注意这里i一定要从idx开始，想想为什么，注意上面退出递归的条件
            swap(nums, idx, i);
            dfs(nums, idx + 1, res);
            swap(nums, idx, i);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = permute(new int[]{1, 2, 3});
    }
}
