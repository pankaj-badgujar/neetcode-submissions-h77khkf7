class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks){
            map.merge(task, 1, Integer::sum);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        for (int frequency : map.values()){
            maxHeap.add(frequency);
        }

        Deque<Pair<Integer, Integer>> queue = new ArrayDeque<>();

        while (!maxHeap.isEmpty() || !queue.isEmpty()){
            time++;

            if (!maxHeap.isEmpty()){
                int count = maxHeap.poll() - 1;
                if (count > 0){
                    queue.addLast(new Pair(count, time + n));
                }
            }

            if (!queue.isEmpty()){
                int topTaskTime = queue.getFirst().getValue();
                if (topTaskTime == time){
                    maxHeap.add(queue.removeFirst().getKey());
                }
            }
        }
        return time;
    }
}
