class Solution {
    public int findJudge(int n, int[][] trust) {
        // person -> indegree
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++){
            map.put(i, 0);
        }
        for (int[] t : trust){
            // remove person if he trusts someone else
            if (map.containsKey(t[0])){
                map.remove(t[0]);
            }
            // update indegree
            if (map.containsKey(t[1])){
                map.merge(t[1], 1, Integer::sum);
            }
        }
        if (map.isEmpty() || map.size() > 1){
            return -1;
        }
        Map.Entry<Integer, Integer> e = map.entrySet().iterator().next(); // should be only one
        return e.getValue() == n - 1 ? e.getKey() : -1;

        
    }
}