class Solution {
    
    boolean bought = false;
    int[] prices;
    Map<String, Integer> dp;

    public int maxProfit(int[] prices) {
        this.prices = prices;
        dp = new HashMap<>();

        return dfs(0, true);
    }

    // we have three choices on any given day (i), we buy or we sell or we hold
    
    private int dfs(int d, boolean canBuy){

        // base case, if prices has ended
        if (d >= prices.length){
            return 0;
        }

        if (dp.containsKey(d + "," + canBuy)){
            return dp.get(d + "," + canBuy);
        }

        // CHOICES

        // 1. HOLD
        int hold = dfs(d + 1, canBuy);

        // 2. BUY (if we dont have stock)
        if (canBuy){
            int buy = dfs(d + 1, false) - prices[d];
            dp.put(d + "," + canBuy,Math.max(hold, buy));
        } else {
            int sell = dfs(d + 2, true) + prices[d];
            dp.put(d + "," + canBuy, Math.max(hold, sell));
        }

        return dp.get(d + "," + canBuy);
    }
}
