class Solution {
    
    boolean bought = false;
    int[] prices;
    Map<String, Integer> dp;

    public int maxProfit(int[] prices) {
        this.prices = prices;
        dp = new HashMap<>();

        return dfs(-1, 0);
    }

    // we have three choices on any given day (i), we buy or we sell or we hold
    
    // RULE: lets mark stock as -1, when we sell a stock
    private int dfs(int stock, int d){

        // base case, if prices has ended
        if (d >= prices.length){
            return 0;
        }

        if (dp.containsKey(stock + "," + d)){
            return dp.get(stock + "," + d);
        }

        // CHOICES

        // 1. HOLD
        int profitCalc = dfs(stock, d + 1);

        // 2. BUY (if we dont have stock)
        if (stock == -1){
            profitCalc = Math.max(profitCalc, dfs(prices[d], d + 1));
        }

        // 3. SELL (if we have stock)
        if (stock > -1){
            profitCalc = Math.max(profitCalc, (prices[d] - stock) + dfs(-1, d + 2));
        }
        dp.put(stock + "," + d, profitCalc);
        return profitCalc;
    }
}
