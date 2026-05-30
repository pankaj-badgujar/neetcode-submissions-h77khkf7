class Solution {

    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public int countComponents(int n, int[][] edges) {
        // fill adjacency map
        for (int[] edge : edges){
            map.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }

        int count = 0;

        for (int i = 0; i < n; i++){
            if (!visited.contains(i)){
                dfs(i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int node){
        if (visited.contains(node)){
            return;
        }
        visited.add(node);
        for (int neighbor : map.getOrDefault(node, new ArrayList<Integer>())){
            dfs(neighbor);
        }
    }
}
