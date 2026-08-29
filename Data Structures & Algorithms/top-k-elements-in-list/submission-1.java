class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // max-heap -> int[]{el, freq}
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        Map<Integer, Integer> count = new HashMap<>();

        for (int n : nums){
            count.merge(n, 1, Integer::sum);
        }
        // we have counted all el and their freqs
        // fill the maxHeap

        for (Map.Entry<Integer, Integer> entry : count.entrySet()){
            maxHeap.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] res = new int[k];
        int idx = 0;
        while (k > 0){
            k--;
            res[idx++] = maxHeap.remove()[0];
        }

        return res;
         
    }
}
