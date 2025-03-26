class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int s = nums.length;
        for(int ele : nums){
            int curr = map.getOrDefault(ele,0);
            map.put(ele,curr+1);
        }
        for(Map.Entry<Integer,Integer>entry : map.entrySet()){
            if(entry.getValue() > (s/2)) return entry.getKey();
        }
        return -1;
    }
}