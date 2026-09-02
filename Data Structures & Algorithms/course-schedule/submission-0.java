class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //[a,b] : if you want to do a then you need to finish b
        // dfs search on each element and sub-element
        //[[0,1], [0,2], [1,3], [1,4], [3,4]]
        // 0 -> 1,2
        // 1 -> 3,4
        // 2 -> 
        // 3 -> 4
        // 4 -> 
        List<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] p : prerequisites) {
            int course = p[0];
            int prerequisite = p[1];

            graph[prerequisite].add(course);
        }

        // 0 = unvisited
        // 1 = currently visiting
        // 2 = completely visited
        int[] state = new int[numCourses];

        for (int course = 0; course < numCourses; course++) {
            if (state[course] == 0) {
                if (!dfs(course, graph, state)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int course, List<Integer>[] graph, int[] state) {

        // Found a cycle
        if (state[course] == 1) {
            return false;
        }

        // Already checked this course
        if (state[course] == 2) {
            return true;
        }

        state[course] = 1;

        for (int next : graph[course]) {
            if (!dfs(next, graph, state)) {
                return false;
            }
        }

        state[course] = 2;

        return true;
    }
}