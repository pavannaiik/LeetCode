class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }

        int[][] memo = new int[n + 2][n + 2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return calculateMaxCoins(1, n, newNums, memo);
    }

    private int calculateMaxCoins(int i, int j, int[] nums, int[][] memo) {
        if (i > j) return 0;
        if (memo[i][j] != -1) return memo[i][j];

        int maxCoins = 0;
        for (int k = i; k <= j; k++) {
            int coins = nums[i - 1] * nums[k] * nums[j + 1]
                      + calculateMaxCoins(i, k - 1, nums, memo)
                      + calculateMaxCoins(k + 1, j, nums, memo);
            maxCoins = Math.max(maxCoins, coins);
        }

        return memo[i][j] = maxCoins;
    }
}
