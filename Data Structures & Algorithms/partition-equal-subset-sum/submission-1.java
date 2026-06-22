class Solution {
    int[] nums;
    Map<String, Boolean> dp;

    public boolean canPartition(int[] nums) {
        int total = 0;
        dp = new HashMap<>();

        for (int n : nums){
            total += n;
        }

        if (total % 2 == 1){
            return false;
        }

        this.nums = nums;
        return dfs(0, total / 2);

    }
    private boolean dfs(int i, int remaining){
        if (i >= nums.length){
            return false;
        }
        if (dp.containsKey(i+","+remaining)){
            return dp.get(i+","+remaining);
        }

        if (remaining - nums[i] == 0){
            return true;
        }

        boolean res = dfs(i + 1, remaining - nums[i]) || dfs(i + 1, remaining);
        dp.put(i+","+remaining, res);
        return res;
    }
}
