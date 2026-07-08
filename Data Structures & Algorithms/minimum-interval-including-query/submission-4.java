class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Map<Integer, Integer> map = new HashMap<>();

        int[] copy = Arrays.stream(queries).sorted().toArray();
        for (int i = 0; i < copy.length; i++){
            for (int j = 0; j < intervals.length; j++){
                int left = intervals[j][0];
                int right = intervals[j][1];

                if (left <= copy[i]){
                    minHeap.offer(new int[]{right - left + 1, right});
                }
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < copy[i]){
                minHeap.poll();
            }
            int val = minHeap.isEmpty() ? -1 : minHeap.peek()[0];
            map.put(copy[i], val);
        }
        int[] res = new int[queries.length];
        int k = 0;
        for (int q : queries){ 
            res[k++] = map.get(q);
        }
        return res;
    }
}
