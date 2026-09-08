class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // also build adj list
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] time : times){
            int a = time[0];
            int b = time[1];
            int p = time[2];

            adj.computeIfAbsent(a, h -> new ArrayList<>()).add(new int[]{b, p});
        }
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        minHeap.add(new int[]{0, k}); // add starting node

        Set<Integer> visited = new HashSet<>();
        int t = 0;
        
        while (!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int w1 = curr[0], n1 = curr[1];

            if (visited.contains(n1)) continue;
            
            visited.add(n1);
            t = w1;
            
            if (adj.containsKey(n1)){
                for (int[] nei : adj.get(n1)){
                    int n2 = nei[0], w2 = nei[1];
                    if (!visited.contains(n2)){
                        minHeap.add(new int[]{w2 + w1, n2});
                    }
                }
            }
        }
        return visited.size() == n ? t : -1;
    }
}
