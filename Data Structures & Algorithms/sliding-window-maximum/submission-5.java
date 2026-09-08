class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // while adding a new el from right, if its is greater than what is in heap, 
        // pop all that out

        int l = 0, idx = 0;
        int[] res = new int[nums.length - k + 1];

        for (int r = 0; r < nums.length; r++){
            if (r - l == k){
                if (maxHeap.peek() == nums[l]){
                    maxHeap.poll();
                }
                l++;
            }

            while (!maxHeap.isEmpty() && maxHeap.peek() < nums[r]){
                maxHeap.poll();
            }
            maxHeap.add(nums[r]);

            if (r - l + 1 == k){
                res[idx++] = maxHeap.peek();
            }
        }
        return res;
        
    }
}
