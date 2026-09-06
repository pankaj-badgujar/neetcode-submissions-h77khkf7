class Solution {
    Map<Integer, Set<Integer>> preReqMap;
    private List<Integer>[] adj;

    private Set<Integer> dfs(int course){
        if (preReqMap.containsKey(course)) return preReqMap.get(course);

        Set<Integer> deps = new HashSet<>();
        for (int pr : adj[course]){
            // do dfs and get indirect dependencies
            deps.addAll(dfs(pr));
        }
        deps.add(course);
        preReqMap.put(course, deps);
        return deps;
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        adj = new ArrayList[numCourses];
        preReqMap = new HashMap<>();

        for (int i = 0; i < numCourses; i++) adj[i] = new ArrayList<>();
        for (int[] p : prerequisites) adj[p[1]].add(p[0]);
        
        // do dfs to fill indirect preqs map
        for (int i = 0; i < numCourses; i++){
            dfs(i);
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] q : queries){
            res.add(preReqMap.get(q[1]).contains(q[0]));
        }
        return res;
    }

}