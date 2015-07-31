import java.util.Stack;

/**
 * Created by yhf on 15/5/23.
 */

/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/

public class SimplifyPath {
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");
        for (String p : paths) {
            if (p.equals(".") || p.equals("")) {
                continue;
            }
            if (p.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(p);
            }
        }

        String ret = "";
        for (String p : stack) {
            ret = ret + p + "/";
        }
        if (ret.length() == 0) {
            return "/";
        }
        ret = ret.substring(0, ret.length() - 1);
        return path.charAt(0) == '/' ? "/" + ret : ret;
    }

    public static void main(String[] args) {
        String[] paths = new String[]{
            "/a/./b/../../c/",
            "/",
            "/.",
            "/../",
            "/a/./c/../..",
            "a/./c/../",
            "/home//foo/",
            "/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///",
            "/.///../JY"
        };
        for (String path : paths) {
            System.out.println(simplifyPath(path));
        }
    }
}
