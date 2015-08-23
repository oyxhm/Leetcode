package src.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhf on 8/22/15.
 */

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * */

public class ClimbingStairs {

    private List<Integer> res;

    public ClimbingStairs() {
        res = new ArrayList<>();
        res.add(1);
        res.add(2);
    }

    public int climbStairs(int n) {
        if (n <= res.size()) {
            return res.get(n - 1);
        }
        for (int i = res.size(); i < n; i++) {
            res.add(res.get(i - 1) + res.get(i - 2));
        }
        return res.get(res.size() - 1);
    }
}
