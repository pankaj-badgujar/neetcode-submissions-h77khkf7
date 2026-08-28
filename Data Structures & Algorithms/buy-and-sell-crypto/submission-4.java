class Solution {
    public int maxProfit(int[] prices) {

        if (prices.length < 2){
            return 0; 
        }
        
        int buyingPrice = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;

        for (int i = 0 ; i < prices.length; i++){
            int price = prices[i];

            if (price < buyingPrice){

                buyingPrice = price;
                profit = Math.max(profit, price * -1);
                
            } else {
                profit = Math.max(profit, price - buyingPrice);
                
            }
        }
        return profit < 0 ? 0 : profit;
    }
    
}

