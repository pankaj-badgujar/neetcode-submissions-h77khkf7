class Solution {
    int[] nums;
    int target;
    

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        return dfs(0, 0);
        
    }

    private int dfs(int i, int total){
        if (i > nums.length){
            return 0;
        }

        if (i == nums.length) {
            return total == target ? 1 : 0;
        }

        int pos = dfs(i + 1, total + nums[i]);
        int neg = dfs(i + 1, total - nums[i]);

        return pos + neg;
    }

}
