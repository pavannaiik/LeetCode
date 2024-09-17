class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=n;i>0;i--){
            for(int j=m;j>0;j--){
                if(i==0 || j==0){
                    dp[i][j]=0;
                    continue;
                }
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i-1][j-1] = 1+dp[i][j];
                }else{
                    dp[i-1][j-1]=Math.max(dp[i][j-1], dp[i-1][j]);
                }

            }
        }
        return dp[0][0];

    }
}