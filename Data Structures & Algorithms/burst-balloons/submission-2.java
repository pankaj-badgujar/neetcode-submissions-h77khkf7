class Solution {
    int[] newNums;
    int[][] dp;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        newNums = new int[n + 2];
        
        newNums[0] = 1;
        newNums[n + 1] = 1;

        dp = new int[newNums.length][newNums.length];
        for (int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        System.arraycopy(nums, 0, newNums, 1, nums.length);
        return dfs(1, newNums.length - 2);
    }

    private int dfs(int l, int r){
        if (l > r){
            return 0;
        }
        if (dp[l][r] != -1){
            return dp[l][r];
        }
        dp[l][r] = 0;
        for (int i = l; i <= r; i++){
            int coins = newNums[l - 1] * newNums[i] * newNums[r + 1];
            coins += dfs(l, i - 1) + dfs(i + 1, r);
            dp[l][r] = Math.max(dp[l][r],coins);
        }
        return dp[l][r];
    }
}
