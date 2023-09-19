class Solution {
    public int numTrees(int n) {
        int dp[] = new int[n+1];
        dp[0]=1;
        for(int x=1;x<=n;x++){
            int val=0;
            for(int j=1;j<=x;j++){
                val += dp[j-1]*dp[x-j];
            }
            dp[x]=val;
        }
        return dp[n];
    }
}