class Solution {
public:
    int rob(vector<int>& nums) {
        int n=nums.size();
        if(n==1) return nums[0];
        if(n==2) return max(nums[0],nums[1]);
        return max(rob(nums, 0, n-1),rob(nums,1,n));
    }
    int rob(vector<int>&nums, int i, int n){
        vector<int>dp(n);
        if(i==0){
            dp[0]=nums[0];
            dp[1]=max(nums[0],nums[1]);
        }else{
            dp[0]=0;
            dp[1]=nums[1];
        }
        for(int i=2;i<n;i++){
            dp[i]=max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[n-1];
    }
};