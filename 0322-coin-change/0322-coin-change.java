class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n = coins.length;
        int[] dp=new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0]=0;
        for(int i=0;i<n;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j]= Math.min(dp[j], dp[j-coins[i]]+1);
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];

    }
}