class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // we create a map of each num vs its frequency
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums ){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
            Map.Entry.comparingByValue(Comparator.reverseOrder()) 
        );
        
        queue.addAll(map.entrySet());

        int res[] = new int[k];
        while(k-- > 0){
            res[k] = queue.poll().getKey();

        }

        return res;
    }
}
