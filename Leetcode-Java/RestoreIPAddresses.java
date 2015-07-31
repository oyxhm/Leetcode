/**
 * Created by yhf on 15/4/19.
 */

/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/

import java.util.*;

public class RestoreIPAddresses {
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        List<String> path = new ArrayList<String>();
        dfs(s, 0, path, res);
        return res;
    }

    public static void dfs(String s, int index, List<String> path, List<String> res) {
        // 结束的条件：path.size() == 4
        if (path.size() == 4) {
            if (index == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (String str : path) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.deleteCharAt(sb.length() - 1);
                res.add(sb.toString());
            }
            return;
        }

        for (int i = index; i < s.length() && i < index + 3; i++) {
            String str = s.substring(index, i + 1);

            // 判断是否为"012"这种情况
            if (s.charAt(index) == '0' && i > index) {
                continue;
            }

            if (validNum(str)) {
                path.add(str);
                dfs(s, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }

    }

    public static boolean validNum(String s) {
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }

    public static void main(String[] args) {
        List<String> res = restoreIpAddresses("25525511135");
    }
}
