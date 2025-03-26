class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int s = nums.length;
        List<Integer> ans = new ArrayList<>();
        for(int ele : nums){
            int curr = map.getOrDefault(ele,0);
            map.put(ele,curr+1);
        }
        for(Map.Entry<Integer,Integer>entry : map.entrySet()){
            if(entry.getValue() > (s/3)) ans.add(entry.getKey());
        }
        return ans;
    }
}