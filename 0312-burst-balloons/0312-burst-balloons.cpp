class Solution {
public:
    int maxCoins(vector<int>& nums) {
        int n = nums.size() + 2;  // Size with padding
        vector<vector<int>> dp(n, vector<int>(n, 0));  // DP table initialization
        vector<int> new_nums(n, 1);  // Padded nums array with 1s at the boundaries

        // Filling new_nums with original nums
        for (int i = 1; i < n - 1; ++i) {
            new_nums[i] = nums[i - 1];
        }

        // Dynamic programming to calculate maxCoins
        for (int len = 2; len < n; ++len) {  // len is the subarray length
            for (int i = 0; i < n - len; ++i) {
                int j = i + len;  // Right boundary of subarray
                for (int k = i + 1; k < j; ++k) {  // Position to burst the last balloon
                    dp[i][j] = max(dp[i][j], dp[i][k] + dp[k][j] + new_nums[i] * new_nums[k] * new_nums[j]);
                }
            }
        }

        return dp[0][n - 1];  // The answer is the maxCoins for the entire range [0, n-1]
    }
};
