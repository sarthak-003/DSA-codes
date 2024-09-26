class Solution {
    public int coinChange(int[] coins, int amount) {
    
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,10001);
        
        return spaceOpt(coins,amount,dp);
    }

    
    static int spaceOpt(int[] coins,int amount,int[] dp){
        for (int j = 0; j <= amount; j++) {
            if(j % coins[0] == 0){
                dp[j] = j / coins[0];
            }
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                int notPick = dp[j];
                int pick = 10001;
                if(j >= coins[i]){
                    pick = 1+dp[j-coins[i]];
                }
                dp[j] = Integer.min(pick,notPick);
            }
        }
        if(dp[amount] >= 10001) return -1;
        return dp[amount];
    }
}