class Solution {
    int[] coins;
    int[][] dp;

    public int change(int amount, int[] coins) {
        this.coins = coins;
        dp = new int[coins.length + 1][amount + 1];
        
        for (int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        return dfs(0, amount);
        
    }

    private int dfs(int i, int remaining){
        if (remaining == 0) return 1;
        if (i >= coins.length || remaining < 0) return 0;    
            
        if (dp[i][remaining] != -1) return dp[i][remaining];
        
        // use coin i again OR skip i entirely
        dp[i][remaining] = dfs(i, remaining - coins[i]) + dfs(i + 1, remaining);
        
        return dp[i][remaining];
    }
}
