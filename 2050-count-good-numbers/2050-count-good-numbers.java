class Solution {
    public int countGoodNumbers(long n) {
        long evenDigits = (n+1)/2;
        long oddDigits = (n)/2;
        int mod=1000000007;
        long evenVal = fastPower(5, evenDigits, mod);
        long oddVal = fastPower(4, oddDigits, mod);
        return (int)((evenVal*oddVal)%mod);
    }
    public long fastPower(long base, long exp, int mod){
        long result=1;
        while(exp > 0){
            if(exp %2==1){
                result = (result*base)%mod;
            }
            base = (base*base)%mod;
            exp = exp/2;
        }
        return result;
    }
}