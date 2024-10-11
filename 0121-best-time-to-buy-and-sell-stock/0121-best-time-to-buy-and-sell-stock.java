class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = prices[0];
        int ans = 0;
        for(int i = 0 ; i< prices.length ; i++){
            if(prices[i] < min){
                min = max = prices[i];
            }
            else{
                if(prices[i] > max){
                    max = prices[i];
                    ans = Integer.max(ans,max-min);
                }
            }
        }
        return ans;
    }
}