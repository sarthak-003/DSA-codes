class Solution {
    public int longestCommonSubsequence(String str1, String str2) {
        int[][] dp = new int[str1.length()][str2.length()];
        for(int[] ele : dp) Arrays.fill(ele, -1);
        return Memoization(str1.length()-1,str2.length()-1,str1,str2,dp);
    }
    static int Memoization(int s1,int s2,String str1,String str2,int[][] dp){
        if(s1<0 || s2<0) return 0;
        if(s1==0 && s2==0){
            if(str1.charAt(s1) == str2.charAt(s2)) return 1;
            return  0;
        }

        if(dp[s1][s2] != -1) return dp[s1][s2];
        char a = str1.charAt(s1);
        char b = str2.charAt(s2);
        int match=0,notMatch = 0;
        if(a==b){
            match = 1 + Memoization(s1-1,s2-1,str1,str2,dp);
        }
        else{
            notMatch = Integer.max(Memoization(s1-1,s2,str1,str2,dp),Memoization(s1,s2-1,str1,str2,dp));
        }
        return dp[s1][s2] = match + notMatch;
    }
}