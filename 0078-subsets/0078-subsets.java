class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int total = 1 << (n);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < total ; i++){
            int t = i;
            ans.add(new ArrayList<>());
            for(int j = 0 ; j < n ; j++){
                if((t & 1) == 1){
                    ans.get(i).add(nums[j]);
                }
                t = t >> 1;
            }
        }
        return ans;
    }
}