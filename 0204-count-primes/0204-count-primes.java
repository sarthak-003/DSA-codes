class Solution {
    public int countPrimes(int n) {
        if(n<=1) return 0;
        boolean[] arr = new boolean[n+1];
        int ans = 0;
        int i = 2;
        while(i < n){
            if(!arr[i]){
                ans+=1;
                arr[i] = true;
                for(int k = i ; k < n ; k+=i) arr[k] = true;
            }
            i+=1;
        }
        return ans;
    }
}