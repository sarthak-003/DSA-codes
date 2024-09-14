class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        //return coinChangeRec(coins,coins.length-1,amount);

        int[][] dp = new int[coins.length][amount + 1];
        for(int[] ele : dp) Arrays.fill(ele,-1);
        int ans = Memoization(coins,coins.length-1,amount,dp);
        //for(int[] ele : dp) System.out.println(Arrays.toString(ele));
        if(ans == 10001) return -1;
        return ans;
    }

    static int Memoization(int[] coins,int i,int amount,int[][] dp){
        if(i == 0) {
            if (amount % coins[i] == 0) {
                return amount / coins[i];
            }
            return 10001;
        }
        if (amount % coins[i] == 0) {
            return dp[i][amount] = amount / coins[i];
        }
        if(dp[i][amount] != -1) return dp[i][amount];
        int pick = 10001;
        if(amount >= coins[i]) pick = 1 + Memoization(coins,i,amount - coins[i],dp);
        int notPick = Memoization(coins,i-1,amount,dp);
        return dp[i][amount] =Integer.min(pick,notPick) ;
    }
}