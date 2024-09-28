class Solution {
    public int longestCommonSubsequence(String str1, String str2) {
        int[][] dp = new int[str1.length()][str2.length()];
        for(int[] ele : dp) Arrays.fill(ele, -1);
        return tabulation(str1,str2,dp);
    }
    static int tabulation(String str1,String str2,int[][] dp){
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                char a = str1.charAt(i);
                char b = str2.charAt(j);
                if(i>0 && j>0){
                    if(a == b){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                    else{
                        dp[i][j] = Integer.max(dp[i-1][j],dp[i][j-1]);
                    }
                } else if (i>0) {
                    if(a==b) dp[i][j] = 1;
                    else dp[i][j] = dp[i-1][j];
                } else if (j>0) {
                    if(a==b) dp[i][j] = 1;
                    else dp[i][j] = dp[i][j-1];
                }
                else {
                    if(a==b) dp[i][j] = 1;
                    else dp[i][j] = 0;
                }
            }
        }
        return dp[str1.length()-1][str2.length()-1];
    }

}