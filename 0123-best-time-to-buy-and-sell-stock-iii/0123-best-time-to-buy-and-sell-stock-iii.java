class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length+1][2][3];
        for(int[][] ele : dp) for(int[] mem : ele) Arrays.fill(mem,-1);
        return Memoization(0,0,2,prices,dp);
    }
    static int Rec(int day,int buy,int trans,int[] prices){
        if(day == prices.length) return 0;

        if(buy == 0){
            int purchase = Integer.MIN_VALUE;
            if(trans > 0) purchase = -1 * prices[day] + Rec(day+1,buy+1,trans,prices);
            int not_purchase = Rec(day+1,buy,trans,prices);
            return Integer.max(purchase,not_purchase);
        }
        int sell = prices[day] + Rec(day+1,buy-1,trans-1,prices);
        int not_sell = Rec(day+1,buy,trans,prices);
        return Integer.max(sell,not_sell);
    }

    static int Memoization(int day,int buy,int trans,int[] prices, int[][][] dp){
        if(day==prices.length) return 0;

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