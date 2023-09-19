class Solution {
    public int numTrees(int n) {
        int dp[] = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int x=2;x<=n;x++){
            for(int j=1;j<=x;j++){
                dp[x] += dp[j-1]*dp[x-j];
            }
        }
        return dp[n];
    }
}