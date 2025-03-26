class Solution {
    public int longestOnes(int[] nums, int k) {
        int len = Integer.MIN_VALUE;
        int l = 0;
        int r = 0;
        int size = nums.length;
        while(r<size && l<=r){
            if(nums[r] ==0) k-=1;
            if(k<0){
                while(l<=r && r<size){
                    if(nums[l]==0) {
                        k+=1;
                        l+=1;
                        break;
                    }
                    l++;
                }
                
            }
            len = Integer.max(len,r-l+1);
            r+=1;
        }
        return len;
    }
}