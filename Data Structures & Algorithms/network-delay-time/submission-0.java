class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        Map<Integer, List<int[]>> adj = new HashMap<>(); // node -> [neighbor, duration]
        for (int[] time : times){
            adj.computeIfAbsent(time[0], l -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        minHeap.add(new int[]{k, 0});

        Set<Integer> visited = new HashSet<>();

        int t = 0;

        while (!minHeap.isEmpty()){
            int[] node = minHeap.remove();

            if (visited.contains(node[0])) continue;
            visited.add(node[0]);
            t = Math.max(t, node[1]);

            // bfs
            List<int[]> neighbors = adj.getOrDefault(node[0], new ArrayList<int[]>());

            for (int[] neighbor : neighbors){
                if (visited.contains(neighbor[0])) continue;
                minHeap.add(new int[]{neighbor[0], node[1] + neighbor[1]});
            }
        }

        return visited.size() == n ? t : -1;
    }
}
