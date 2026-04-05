class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int global = 0;
        for(int n : nums){
            set.add(n);
        }
        for(int n : nums){
            if(!set.contains(n - 1)){
                // we found starting node
                int count = 1;
                int startingNode = n;
                //check how long we have it
                while(set.contains(++n)){
                    count++;
                }
                global = Math.max(count, global);
            }
        }
        return global;    
    }
}
