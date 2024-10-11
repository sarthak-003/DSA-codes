class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
        for(int[] ele : dp) Arrays.fill(ele,-1);
        return Memoization(0,0,prices,dp);
    }
    static int Memoization(int day,int buy,int[] prices, int[][] dp){
        if(day==prices.length) return 0;

        if(dp[day][buy] != -1) return dp[day][buy];

        if(buy == 0){
            int purchase = -1 * prices[day] + Memoization(day+1,buy+1,prices,dp);
            int not_purchase = Memoization(day+1,buy,prices,dp);
            return dp[day][buy] =  Integer.max(purchase,not_purchase);
        }
        int sell = prices[day] + Memoization(day+1,buy-1,prices,dp);
        int not_sell = Memoization(day+1,buy,prices,dp);
        return dp[day][buy] =  Integer.max(sell,not_sell);
    }
}