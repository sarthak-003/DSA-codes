class Solution {
    public int findTargetSumWays(int[] arr, int tgt) {
        int sum = Arrays.stream(arr).sum();
        if(tgt < 0 && -1 * tgt > sum) return 0;
        if(tgt > 0 && sum < tgt) return 0;
        if((sum + tgt)%2 != 0) return 0; 
        int newTgt = (sum + tgt) / 2;
    
        int[][] dp = new int[arr.length][newTgt+1];
        for(int[] ele : dp) Arrays.fill(ele,0);

        return Tabulation(arr.length-1,newTgt,arr,dp);
    }
    static int Rec(int i,int tgt,int[] arr){
        if(i==-1){
            if(tgt == 0 ) return 1;
            return 0;
        }
        int pick=0,notPick=0;
        notPick = Rec(i-1,tgt , arr);
        if(tgt >= arr[i]) pick =  Rec(i-1,tgt - arr[i] ,arr);

        return pick+notPick;
    }

    static int Memoization(int i,int tgt,int[] arr,int[][] dp){
        if(i==-1){
            if(tgt == 0 ) return 1;
            return 0;
        }
        if(dp[i][tgt] != -1) return dp[i][tgt];
        int pick=0,notPick=0;
        notPick = Rec(i-1,tgt , arr);
        if(tgt >= arr[i]) pick =  Rec(i-1,tgt - arr[i] ,arr);

        return dp[i][tgt] = pick+notPick;
    }

    static int Tabulation(int i,int sum,int[] arr,int[][] dp){
        for(int j = 0 ; j < arr.length ; j++){
            dp[j][0] = 1;
        }
        if(arr[0] <= sum){
            dp[0][arr[0]] +=1;
        }
        for (int j = 1; j < arr.length; j++) {
            for (int k = 0; k <= sum; k++) {
                int pick = 0;
                if(j>0 && k >= arr[j]){
                    pick = dp[j-1][k - arr[j]];
                }
                int not_pick = dp[j-1][k];
                dp[j][k] = (pick + not_pick) ;
            }
        }
        return dp[arr.length-1][sum];
    }
}