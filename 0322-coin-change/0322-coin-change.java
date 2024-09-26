class Solution {
    public int coinChange(int[] coins, int amount) {
    
        int[][] dp = new int[coins.length][amount + 1];
        for(int[] ele : dp) Arrays.fill(ele,10001);
        
        return tabulation(coins,amount,dp);
    }

    
    static int tabulation(int[] coins,int amount,int[][] dp){
        for(int i = 0 ; i < dp.length; i++){
            dp[i][0] = 0;
        }
        for (int j = 0; j <= amount; j++) {
            if(j % coins[0] == 0){
                dp[0][j] = j / coins[0];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int notPick = dp[i-1][j];
                int pick = 10001;
                if(j >= coins[i]){
                    pick = 1+dp[i][j-coins[i]];
                }
                dp[i][j] = Integer.min(pick,notPick);
            }
        }

        if(dp[dp.length-1][amount] >= 10001) return -1;
        return dp[dp.length-1][amount];
    }
}