class Solution {
    int[] nums;
    int target;
    Map<String, Integer> dp;

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        dp = new HashMap<>();

        return dfs(0, 0);
        
    }

    private int dfs(int i, int total){
        if (i > nums.length){
            return 0;
        }
        String key = i + "_" + total;
        if (dp.containsKey(key)){
            return dp.get(key);
        }

        if (i == nums.length) {
            return total == target ? 1 : 0;
        }

        int pos = dfs(i + 1, total + nums[i]);
        int neg = dfs(i + 1, total - nums[i]);

        dp.put(key, pos + neg);

        return pos + neg;
    }

}
