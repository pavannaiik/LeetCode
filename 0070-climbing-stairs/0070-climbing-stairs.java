class Solution {
    public int climbStairs(int n) {
        if(n==1 || n==2){
            return n;
        }
        int dp1=2, dp2=1;
        for(int i=2;i<n;i++){
            int dp= dp1+dp2;
            dp2=dp1;
            dp1=dp;
        }
        return dp1;
    }
}