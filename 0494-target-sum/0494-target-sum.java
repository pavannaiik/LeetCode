class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // If the target is not achievable, return 0
        if (Math.abs(target) > totalSum || (totalSum + target) % 2 != 0) {
            return 0;
        }

        int subsetSum = (totalSum + target) / 2;

        // Use a 1D DP array to calculate the number of ways to achieve the subset sum
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1;  // There's 1 way to achieve sum 0 (by using no elements)

        // Populate the DP array
        for (int num : nums) {
            for (int j = subsetSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[subsetSum];
    }
}
