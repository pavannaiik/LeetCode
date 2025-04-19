class Solution {
    public double myPow(double x, int n) {
        return myPower(x, (long)n);
    }
    public double myPower(double x, long n){
        if(n==0) return 1;
        if(n<0){
            return 1.0/myPower(x, -n);
        }
        if(n%2==0){
            return myPower(x*x, n/2);
        }else{
            return x*myPower(x*x,(n-1)/2);
        }
    }
}