class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        int profit = 0;
        int cheapestPrice = prices[0];
        for(int price : prices){
            if(price < cheapestPrice){
                cheapestPrice = price;
            } else {
                profit = Math.max(profit, price - cheapestPrice);
            }
        } 
        return profit;
    }
}
