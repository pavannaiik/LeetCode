class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+2][n+2];
        // add 1 to the left and right of the array
        int[] newNum = new int[n+2];
        newNum[0]=newNum[n+1]=1;
        for(int i=1;i<=n;i++){
            newNum[i]=nums[i-1]; // copying the elemenst of num into newNum
        }
        for(int length =1;length<=n;length++){
            for(int left = 1;left<=n-length+1;left++){
                int right = left+length-1;
                for(int i=left;i<=right;i++){
                    dp[left][right]= Math.max(dp[left][right],(newNum[left-1]*newNum[i]*newNum[right+1]) + dp[left][i-1]+dp[i+1][right]);
                }
            }
        }
        return dp[1][n];
        
        
    }
    
}