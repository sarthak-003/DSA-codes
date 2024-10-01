class Solution {
    public int minInsertions(String s) {
        int l = s.length();
        int[][] dp = new int[l][l];
        for(int[] ele : dp) Arrays.fill(ele, -1);
        return Memoization(0,l-1,dp,s);
   
    }
    static int Memoization(int s,int e,int[][] dp,String str){
        if(s>=e) return 0;
        if(dp[s][e]!=-1) return dp[s][e];
        char a = str.charAt(s);
        char b = str.charAt(e);

        if(a==b) return dp[s][e] = Memoization(s+1,e-1,dp,str);
        return  dp[s][e] = Integer.min(1+Memoization(s+1,e,dp,str),1+Memoization(s,e-1,dp,str));
    }
}