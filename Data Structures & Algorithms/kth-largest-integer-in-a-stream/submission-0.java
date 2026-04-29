class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;

        for (int n : nums){
            this.add(n);
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        while (minHeap.size() > k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
