class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length+1][2][k+1];
        for(int[][] ele : dp) for(int[] mem : ele) Arrays.fill(mem,-1);
        return Memoization(0,0,k,prices,dp);
    }
    static int Memoization(int day,int buy,int trans,int[] prices, int[][][] dp){
        if(trans == 0 || day==prices.length) return 0;

        if(dp[day][buy][trans] != -1) return dp[day][buy][trans];

        if(buy == 0){
            int purchase = Integer.MIN_VALUE;
            if(trans>0) purchase = -1 * prices[day] + Memoization(day+1,buy+1,trans,prices,dp);
            int not_purchase = Memoization(day+1,buy,trans,prices,dp);
            return dp[day][buy][trans] =  Integer.max(purchase,not_purchase);
        }
        int sell = prices[day] + Memoization(day+1,buy-1,trans-1,prices,dp);
        int not_sell = Memoization(day+1,buy,trans,prices,dp);
        return dp[day][buy][trans] =  Integer.max(sell,not_sell);
    }
}