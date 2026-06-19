class Solution {
    int[] coins;
    Map<Integer, Integer> dp;
    int change = Integer.MAX_VALUE;


    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        dp = new HashMap<>();
        int minCoins = dfs(amount);
        return minCoins == Integer.MAX_VALUE ? -1 :  minCoins;
    }

    private int dfs(int amount){
        if (amount == 0) return 0;
        if (dp.containsKey(amount)){
            return dp.get(amount);
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins){
            if (amount - coin >= 0){
                int result = dfs(amount - coin);
                if (result != Integer.MAX_VALUE){
                    res = Math.min(res, 1 + result);
                }
            }
        }
        dp.put(amount, res);
        return res;
        
    }
}
