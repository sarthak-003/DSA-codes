class Solution {
    public int minBitFlips(int start, int goal) {
        return noOfSetBits(start^goal);
    }

    public int noOfSetBits(int n) {
        int count = 0;
        while(n!=0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
}