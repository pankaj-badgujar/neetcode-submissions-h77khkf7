class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Map<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // build the frequency map
        for (int n : hand){
            freq.merge(n, 1, Integer::sum);
        }

        for (Integer key : freq.keySet()){
            minHeap.add(key);
        }

        while (!minHeap.isEmpty()){
            int first = minHeap.peek();
            
            for (int i = first; i < first + groupSize; i++){
                if (!freq.containsKey(i)) return false;

                freq.merge(i, -1, Integer::sum); // use it for the group

                if (freq.get(i) == 0){
                    if (minHeap.peek() != i) return false;
                    minHeap.remove();
                }
            }
            
        }

        return true;



        
    }
}
