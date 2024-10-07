class Solution {
    public int hammingDistance(int x, int y) {
        return noOfSetBits(x^y);
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