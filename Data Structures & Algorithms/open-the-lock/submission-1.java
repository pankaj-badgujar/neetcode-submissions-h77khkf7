class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if (visited.contains("0000")) return -1;
        
        Deque<String> q = new ArrayDeque<>();
        q.offer("0000");
        visited.add("0000");

        int moves = 0;
        while (!q.isEmpty()){

            int size = q.size();
            for (int i = 0; i < size; i++){
                String lock = q.poll();
                if (lock.equals(target)){
                    return moves;
                }

                for (String child : getChildren(lock)){
                    if (!visited.contains(child)){
                        q.offer(child);
                        visited.add(child);
                    }
                }
            }
            moves++;
        }
        return -1;
               
    }
    private List<String> getChildren(String lock){
        List<String> res = new ArrayList<>();

        for (int i = 0; i < 4; i++){
            char[] arr = lock.toCharArray();
            
            arr[i] = (char)(((arr[i] - '0' + 1) % 10) + '0');
            res.add(new String(arr));
            
            arr = lock.toCharArray();
            arr[i] = (char)(((arr[i] - '0' - 1 + 10) % 10) + '0');
            res.add(new String(arr));
        }
        return res;
    }
}