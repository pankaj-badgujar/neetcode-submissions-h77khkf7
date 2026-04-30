class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) ->
                    (b[0] * b[0] + b[1] * b[1]) -
                    (a[0] * a[0] + a[1] * a[1])
            );

        for (int[] point : points){
            maxHeap.offer(point);

            if (maxHeap.size() > k){
                maxHeap.poll();
            }
            System.out.println("maxHeap size: " + maxHeap.size());
            System.out.println("maxHeap: " + maxHeap.peek()[0] + "][" + maxHeap.peek()[1]);
        }

        // now what we are left with is points with least distance because we polled the most distance
        int[][] result = new int[maxHeap.size()][2];

        int i = 0;
        while (!maxHeap.isEmpty()){
            result[i++] = maxHeap.poll();
        }
        return result;
    }
}
