class Solution {
    int[] nums;

    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int n : nums){
            total += n;
        }
        if (total % 2 == 1){
            return false;
        }

        this.nums = nums;
        return dfs(0, 0, total / 2);

    }
    private boolean dfs(int i, int sum, int target){
        if (i >= nums.length){
            return false;
        }

        if (sum + nums[i] == target){
            return true;
        }

        boolean res = dfs(i + 1, sum + nums[i], target) || dfs(i + 1, sum, target);
        return res;
    }
}
