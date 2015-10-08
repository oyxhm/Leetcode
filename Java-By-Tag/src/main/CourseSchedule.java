package src.main;

/**
 * Created by yhf on 10/7/15.
 */

import java.util.*;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed
 * as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * For example:
 *
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 *
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you
 * should also have finished course 1. So it is impossible.
 */

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // BFS
        if (numCourses == 0) {
            return true;
        }

        int[] numPreqs = new int[numCourses];
        for (int[] preq : prerequisites) {
            numPreqs[preq[0]]++;
        }

        Queue<Integer> q = new ArrayDeque<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (numPreqs[i] == 0) {
                q.add(i);
            }
        }
        int numNoPreqs = q.size();

        while (!q.isEmpty()) {
            int course = q.remove();
            for (int[] preq : prerequisites) {
                if (preq[1] == course) {
                    numPreqs[preq[0]]--;
                    if (numPreqs[preq[0]] == 0) {
                        q.add(preq[0]);
                        numNoPreqs++;
                    }
                }
            }
        }

        return numNoPreqs == numCourses;
    }
}
