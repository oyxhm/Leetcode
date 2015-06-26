import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhf on 15/6/26.
 */

/*
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        int pre = 0;
        List<String> res = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            while (i < nums.length && nums[i] - nums[i - 1] == 1) {
                i++;
            }
            if (i == pre + 1) {
                res.add(String.valueOf(nums[pre]));
            } else {
                res.add(String.valueOf(nums[pre]) + "->" + String.valueOf(nums[i - 1]));
            }
            pre = i;
        }
        if (pre == nums.length - 1) {
            res.add(String.valueOf(nums[pre]));
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> res = summaryRanges(new int[]{0, 2, 4, 5, 7});
    }
}
