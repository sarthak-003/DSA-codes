class Solution {
    public int hammingWeight(int n) {
        int temp = n; 
        int count = 0;
        while(temp!=0){
            count += temp & 1;
            temp = temp >> 1;
        }
        return count;
    }
}