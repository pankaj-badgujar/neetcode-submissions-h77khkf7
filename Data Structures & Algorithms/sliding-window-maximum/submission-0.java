class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        // 0: index
        // 1: element
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        
        // first fill the window elements in the heap
        for(int i = 0; i < k; i++){
            maxHeap.add(new int[]{i, nums[i]});
        }

        int[] res = new int[nums.length - k + 1];
        int resCounter = 0;
        res[resCounter++] = maxHeap.peek()[1];

        int l = 1;

        for(int r = k; r < nums.length; r++){
            // we added new element in the heap
            maxHeap.add(new int[]{ r, nums[r] });

            // now to get, we just peek but check its index if its out of the window
            // if it is, we poll and peek next
            // only when this loop ends, we store it in res,
            while (maxHeap.peek()[0] < l){
                maxHeap.poll();
            }
            res[resCounter++] = maxHeap.peek()[1];
            // move l forward now
            l++;
        }

    return res;
    }
}
