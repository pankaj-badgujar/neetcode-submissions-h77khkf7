class Solution {
    // lets first build adjacency matrix
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visitSet = new HashSet<>();
    Set<Integer> completed = new HashSet<>();
    int[] res;
    int finished = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        res = new int[numCourses];
        for (int[] preq : prerequisites) {
            map.computeIfAbsent(preq[0], k -> new ArrayList<Integer>()).add(preq[1]);
        }

        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c)) {
                return new int[0];
            }
        }
        return res;
    }

    private boolean dfs(int crs) {
        if (visitSet.contains(crs)) {
            // we found a cycle
            return false;
        }
        if (completed.contains(crs)){
            return true;
        }

        // if map doesnt have the key
        // or if it does, but its arr is empty
        // means it does not have a preq
        // if (!map.containsKey(crs) || map.get(crs).isEmpty()) {
        //     // we need to add it in res now
        //         res[finished++] = crs;
        //         completed.add(crs);

        //     return true;
        // }
        visitSet.add(crs);

        for (int preq : map.getOrDefault(crs, new ArrayList<>())) {
            if (!dfs(preq)) {
                return false;
            }
        }

        visitSet.remove(crs);
        completed.add(crs);
        
        res[finished++] = crs;

        map.put(crs, new ArrayList<Integer>());

        return true;
    }
}
