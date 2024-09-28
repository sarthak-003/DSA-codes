class Solution {
    public int minElement(int[] nums) {
        int min = 1000000;
        for(int i = 0 ; i<nums.length ; i++){
            int x = sumdigit(nums[i]);
            if(x < min){
                min = x;
            }
        }
        return min;
    }
    public static int sumdigit(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}