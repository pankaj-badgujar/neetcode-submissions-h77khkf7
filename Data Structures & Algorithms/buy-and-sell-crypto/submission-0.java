class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        int profit = 0;
        for(int i = 0 ; i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++){
                System.out.println("i = " + i);
                System.out.println("j = " + j + "\n--\n");
                if(prices[j] < prices[i]){
                    i = j - 1;
                    break;
                }
                profit = Math.max(profit, prices[j] - prices[i]);
            }
        }
        return profit;
    }
}
