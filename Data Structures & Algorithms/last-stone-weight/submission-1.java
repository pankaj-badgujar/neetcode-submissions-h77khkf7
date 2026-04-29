class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        for (int stone : stones){
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1){
            int firstBiggestStone = maxHeap.poll();
            int secondBiggestStone = maxHeap.poll();

            if (firstBiggestStone != secondBiggestStone){
                maxHeap.add(firstBiggestStone - secondBiggestStone);
            }
        }
        return maxHeap.size() == 0 ? 0 : maxHeap.poll();
    }
}
