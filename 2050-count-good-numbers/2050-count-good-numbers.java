class Solution {
    static long mod = (long) (Math.pow(10,9) + 7);
    public int countGoodNumbers(long n) {
        long c = n / 2;
        long ans = (func((long)4 , c) % mod * func((long)5,n-c) % mod ) % mod;
        return (int)ans;
        //return rec(n);
    }
    static int rec(long n){
        if(n <= 2 && n%2 == 1) return 5;
        else if(n <= 2 && n%2 == 0) return 4*5;

        if(n%2 == 1) return 5 * rec(n-1);
        return 4 * rec(n-1); 
    }

    static long func(long a, long b){
        long ans = 1;

        a = a % mod;
        if(a==0) return 0;

        while(b > 0){
            if(b%2==1) ans = (ans*a) % mod;
            b=b>>1;
            a = (a*a) % mod;
        }
        return ans;
    }
}
