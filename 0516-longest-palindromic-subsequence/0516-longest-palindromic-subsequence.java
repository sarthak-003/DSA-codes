class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int[] ele : dp) Arrays.fill(ele,-1);
        return Memoization(0,s.length()-1,dp,s);
        
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
}