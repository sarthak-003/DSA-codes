class Solution {
    public int change(int amount, int[] coins) {
        if(amount==0) return 1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,0);
        return spaceOpt(amount,coins,dp);
    }
    static int spaceOpt(int amount, int[] coins, int[] dp) {
        for(int j = 1 ; j <= amount ; j++){
            if(j % coins[0] == 0) dp[j] = 1;
        }
        for(int i = 1 ; i < coins.length ; i++){
            for (int j = 1; j <= amount; j++) {
                int notPick = dp[j];
                int pick = 0;
                if(j >= coins[i]){
                    pick = dp[j-coins[i]];
                    if(j-coins[i] ==0) pick+=1;
                }
                dp[j] = pick + notPick;
            }
        }
        return dp[amount];
    }
}