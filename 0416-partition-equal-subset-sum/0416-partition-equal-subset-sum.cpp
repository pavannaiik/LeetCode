class Solution {
public:
    bool canPartition(vector<int>& nums) {
       int n = nums.size();
        int sum = accumulate(nums.begin(), nums.end(), 0);

        if (sum & 1) return false;
        sum >>= 1;

        bitset<10001> dp(1);
        for (int v: nums){
            dp |= dp << v;
            if (dp[sum]) return true;
        }

        return false;

    }
};