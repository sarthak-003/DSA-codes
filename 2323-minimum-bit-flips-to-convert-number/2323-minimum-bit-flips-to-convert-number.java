class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0;
        while(true){
            if(start == 0 && goal == 0) break;
            if((start & 1) != (goal & 1)){
                count+=1;
            }
            start = start >> 1;
            goal = goal >> 1;
        }
        return count;
    }
}