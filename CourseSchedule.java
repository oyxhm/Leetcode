import java.util.*;

/**
 * Created by yhf on 15/5/31.
 */

/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

click to show more hints.

Hints:
This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
Topological sort could also be done via BFS.
*/

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // DFS
        if (numCourses == 0 || prerequisites.length == 0) {
            return true;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] p : prerequisites) {
            if (map.containsKey(p[0])) {
                map.get(p[0]).add(p[1]);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(p[1]);
                map.put(p[0], l);
            }
        }

        int[] visited = new int[numCourses];
        // 0: not visited
        // 1: visiting
        // 2: visited

        for (int i = 0; i < numCourses; i++) {
            if (!canFinish(map, visited, i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean canFinish(Map<Integer, List<Integer>> map, int[] visited, int i) {
        if (visited[i] == 1) { // visiting, form a circle
            return false;
        }
        if (visited[i] == 2) {
            return true;
        }

        visited[i] = 1;
        if (map.containsKey(i)) {
            for (int toVisit : map.get(i)) {
                if (!canFinish(map, visited, toVisit)) {
                    return false;
                }
            }
        }
        visited[i] = 2;

        return true;
    }

    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        // BFS
        if (numCourses == 0 || prerequisites.length == 0) {
            return true;
        }

        int[] numPres = new int[numCourses];
        for (int pre[] : prerequisites) {
            numPres[pre[0]]++;   // numPres[i] is the number of prerequisites of course i
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < numPres.length; i++) {
            if (numPres[i] == 0) {
                q.add(i);
            }
        }

        int numNoPres = q.size();  // number of courses without prerequisite
        while (!q.isEmpty()) {
            int thisPre = q.remove();
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == thisPre) {
                    numPres[prerequisites[i][0]]--;
                    if (numPres[prerequisites[i][0]] == 0) {
                        q.add(prerequisites[i][0]);
                        numNoPres++;
                    }
                }
            }
        }
        return numNoPres == numCourses;
    }

    public static void main(String[] args) {
//        boolean can = canFinish(3, new int[][]{{1, 0}, {2, 1}});
        boolean can = canFinish2(3, new int[][]{{1, 0}, {2, 1}});
    }
}
