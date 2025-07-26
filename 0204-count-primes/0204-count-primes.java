class Solution {
    public int countPrimes(int n) {
        int[] dp = new int[n];
        int count =0;
        for(int i=2;i<n;i++){
            if(dp[i]!=-1){
                count++;
                for(int j=2;i*j<n;j++){
                    dp[i*j]=-1;
                }
            }
        }
        return count;
    }
}