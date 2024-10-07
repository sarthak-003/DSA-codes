class Solution {
    public String shortestCommonSupersequence(String s, String t) {
        
        int[][] dp = new int[s.length()+1][t.length()+1];
        tabulation(s,t,dp);
        return func(dp.length-1,dp[0].length-1,dp,s,t,"");
    }
    static void tabulation(String s,String t,int[][] dp){
        int l1 = s.length(),l2 = t.length();
        for (int i = 1; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= l2; i++) {
            dp[0][i] = i;
        }
        for(int i = 1 ; i <= l1 ; i++){
            for (int j = 1; j <= l2; j++) {
                char a = s.charAt(i-1);
                char b = t.charAt(j-1);
                if(a==b) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = 1 + Integer.min(dp[i-1][j],dp[i][j-1]);
            }
        }
    }
    static String func(int i,int j,int[][] dp,String s,String t,String p){
        if(i==0 && j==0) return p;
        if(i==0) return t.substring(0,j) +p;
        if(j==0) return s.substring(0,i) +p;

        char a = s.charAt(i-1);
        char b = t.charAt(j-1);
        if(a!=b) {
            if(dp[i][j] == dp[i-1][j] +1){
                return func(i-1,j,dp,s,t,a+p);
            }
            else return func(i,j-1,dp,s,t,b+p);
        }
        return func(i-1,j-1,dp,s,t,a+p);
    }
}