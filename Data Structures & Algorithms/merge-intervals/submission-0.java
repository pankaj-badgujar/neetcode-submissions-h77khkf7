class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        // for (int[] interval : intervals){
        //     System.out.println(Arrays.toString(interval));
        // }

        List<int[]> res = new ArrayList<>();
        int[] candidate = intervals[0];

        for (int i = 1; i < intervals.length; i++){
            // if they are not overlapping

            if (candidate[1] < intervals[i][0]){
                res.add(candidate);
                candidate = intervals[i];
            } else {
                // they overlap
                candidate = new int[]{
                    Math.min(candidate[0], intervals[i][0]),
                    Math.max(candidate[1], intervals[i][1])
                };
            }
        }
        res.add(candidate);

        return res.toArray(new int[res.size()][]);
    }
}
