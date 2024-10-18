class Solution {
    int burstBallons(int i, int j, vector<int> &nums,vector<vector<int>>&dp ){
        if(i > j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int maxCoins = INT_MIN;
        for(int idx = i; idx<=j;idx++){
            int cost = nums.at(i-1)*nums.at(idx)*nums.at(j+1) + burstBallons(i, idx-1,nums,dp) + burstBallons(idx+1, j, nums,dp);
            maxCoins = max(maxCoins, cost);
        }
        return dp[i][j] = maxCoins;
    }
public:
    int maxCoins(vector<int>& nums) {
        int n = nums.size();
        nums.push_back(1);
        nums.insert(nums.begin(), 1);
        vector<vector<int>>dp(n+1,vector<int>(n+1,-1));
        return burstBallons(1, n,nums,dp);
    }
};