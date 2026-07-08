class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        // for (int[] interval : intervals){
        //     System.out.println(Arrays.toString(interval));
        // }

        int[] curr = intervals[0];
        int removals = 0;
        
        for (int i = 1; i < intervals.length; i++){
            // check if i overlaps with i + 1
            int[] next = intervals[i];

            if (next[0] < curr[1]){
                removals++;
                // keep the one that ends early
                if (curr[1] > next[1]){
                    curr = next;
                }
            } else {
                curr = next;
            }
        }
        return removals;
    }
}
