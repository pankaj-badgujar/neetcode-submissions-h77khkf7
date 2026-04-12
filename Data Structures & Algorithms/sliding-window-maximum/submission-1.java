class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>(); // take indices;
        int l = 0, r = 0;

        while(r < n){
            while (!deque.isEmpty() && nums[r] > nums[deque.getLast()]){
                deque.removeLast();
            }
            deque.addLast(r);
            
            if (l > deque.getFirst()){
                deque.removeFirst();
            }

            if ((r + 1) >= k){
                output[l] = nums[deque.getFirst()];
                l++;
            }
            r++;
        }

        return output;
    }
}
