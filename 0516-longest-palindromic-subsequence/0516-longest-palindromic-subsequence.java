class Solution {
    public int longestPalindromeSubseq(String s) {
        // int[][] dp = new int[s.length()][s.length()];
        // for(int[] ele : dp) Arrays.fill(ele,-1);
        // return Memoization(0,s.length()-1,dp,s);
        return tabulation(s);
        
    }
    static int rec(int s,int e,String str) {
        if(s>e) return 0;

        if(s==e) return 1;
        if(str.charAt(s) == str.charAt(e)) return 2 + rec(s+1,e-1,str);

        return Integer.max(rec(s+1,e,str),rec(s,e-1,str));
    }
    static int Memoization(int s,int e,int[][] dp,String str){
        if(s>e) return 0;

        if(s==e) return 1;
        if(dp[s][e]!=-1) return dp[s][e];
        if(str.charAt(s) == str.charAt(e)) return dp[s][e] = 2 + Memoization(s+1,e-1,dp,str);

        return dp[s][e] = Integer.max(Memoization(s+1,e,dp,str),Memoization(s,e-1,dp,str));
    }
    static int tabulation(String s){
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if(j==i) dp[i][j] = 1;
            }
        }

        for(int i = dp.length-1-1;i>=0;i--){
            for(int j = i+1 ; j < dp.length ; j++){
                char a = s.charAt(i);
                char b = s.charAt(j);
                if(a==b) dp[i][j] = 2 + dp[i+1][j-1];
                else dp[i][j] = Integer.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        return dp[0][dp.length-1];
    }
}