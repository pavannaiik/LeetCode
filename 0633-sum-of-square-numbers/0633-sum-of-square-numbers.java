class Solution {
    public boolean judgeSquareSum(int c) {
        for(long i=0;i*i<=c;i++){
            int b = c-(int)(i*i);
            if(bs(0,b,b)){
                return true;
            }
        }
        return false;
    }
    public boolean bs(long low, long high, int rem){
        while(low<=high){
            long mid = low+(high-low)/2;
            if(mid*mid == rem) return true;
            else if(mid*mid>rem){
                high =mid-1;
            }else{
                low=mid+1;
            }
        }
        return false;
    }
}