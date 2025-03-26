class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : nums){
            int curr = map.getOrDefault(ele,0);
            map.put(ele,curr+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(x->x.getValue()));
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            heap.add(entry);
            if(heap.size() > k) heap.poll();
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll().getKey();
        }
        return ans;
    }
}