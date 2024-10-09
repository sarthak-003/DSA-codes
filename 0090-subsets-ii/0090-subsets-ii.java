class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        return subset(nums);
    }
    static List<List<Integer>> subset(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int strt = 0;
        int end=0;
        for(int i=0;i< arr.length;i++){
            int n= outer.size();
            if(i>0 && arr[i]==arr[i-1]){
                strt = end+1;
            }
            else strt = 0;
            end= outer.size()-1;
            for(int j=strt;j<n;j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
}