class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dp = new int[n][n];
        for(int[] d:dp){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        for(int i=0;i<edges.length;i++){
                dp[edges[i][0]][edges[i][1]]= edges[i][2];
                dp[edges[i][1]][edges[i][0]]= edges[i][2];
        }
        for(int i=0;i<n;i++) {
            dp[i][i]=0;
            }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(dp[j][i] != Integer.MAX_VALUE && dp[i][k]!=Integer.MAX_VALUE)
                    dp[j][k] = Math.min(dp[j][k],dp[j][i]+dp[i][k]);
                }
            }
        }
        int ans = -1;
        int minCount =n;
        for(int i=0;i<n;i++){
            int cnt =0;
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(dp[i][j] <= distanceThreshold){
                    cnt++;
                }
            }
            if(cnt <= minCount){
                minCount = cnt;
                ans = i;
            }
        }
        return ans;

    }
}