class Solution {
    public int minCostConnectPoints(int[][] points) {

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]); // we store [weight, index]
        

        minHeap.offer(new int[]{0, 0});
        int res = 0;

        while (visited.size() != points.length){
            int[] entry = minHeap.poll();
            int idx = entry[1];
            int weight = entry[0];

            if (visited.contains(idx)) continue;
            visited.add(idx);

            res += weight; // we add the distance

            // do bfs
            for (int i = 0; i < points.length; i++){
                if (i == idx) continue;

                if (!visited.contains(i)){
                    int d = Math.abs(points[i][0] - points[idx][0]) + Math.abs(points[i][1] - points[idx][1]);
                    minHeap.offer(new int[]{d, i});
                }
            }
        }
        return res;
    }
}
