class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        if (n < 1){
            return true;
        }

        for (int[] edge : edges){
            map.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        boolean traversal = dfs(0, -1);
        

        return traversal ? visited.size() == n : false;
    }
    private boolean dfs(int i, int prev){
        if (visited.contains(i)){
            return false;
        }
        visited.add(i);

        for (int neighbor : map.getOrDefault(i, new ArrayList<Integer>())){
            if (neighbor == prev) continue;

            if (!dfs(neighbor, i)){
                return false;
            }
        }
        return true;
    }
}
