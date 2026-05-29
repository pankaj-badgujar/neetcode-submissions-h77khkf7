class Solution {

    private boolean dfs(int crs, Map<Integer, List<Integer>> map, Set<Integer> visitSet){
        if (visitSet.contains(crs)){
            // that means there is a cycle
            return false;
        }
        if (!map.containsKey(crs) || map.get(crs).isEmpty()){
            // no pre-requesites means the course can be completed
            return true;
        }
        visitSet.add(crs);
        for (int preq : map.get(crs)){
            if (!dfs(preq, map, visitSet)){
                return false;
            }
        }
        // now we reach here means we have completed prerequisites
        visitSet.remove(crs); // to avoid cycles as visit means checked but not yet completed
        map.put(crs, new ArrayList<Integer>());
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visitSet = new HashSet<>();

        for(int[] preq : prerequisites){
            map.computeIfAbsent(preq[0], k -> new ArrayList<Integer>()).add(preq[1]);
        }

        for (int i = 0; i < numCourses; i++){
            if(!dfs(i, map, visitSet)){
                return false;
            }
        }
        return true;
    }
}
