class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int sum=0;
        for(int n:nums) sum+=n;
        if(sum%2==1) return false;
        int target=sum/2;
        vector<bool> dp(target + 1, false);  // dp[i] means if we can get sum i from the subset
        dp[0] = true;  // A subset sum of 0 is always possible (by taking no elements)
        
        // Iterate through each number in nums
        for (int num : nums) {
            // Update dp array from right to left (to avoid overwriting results prematurely)
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        
        // Check if it's possible to achieve the target sum
        return dp[target];

    }
};