class Solution {
    public int minOperations(int[] nums) {
        int N = nums.length;
        int ans = N;
        int j = 0;

        // Sort the array
        Arrays.sort(nums);

        // Remove duplicates to only keep unique elements
        int M = 1;
        for (int i = 1; i < N; ++i) {
            if (nums[i] != nums[i - 1]) {
                nums[M] = nums[i];
                M++;
            }
        }

        for (int i = 0; i < M; ++i) {
            while (j < M && nums[j] < nums[i] + N) {
                ++j;
            }
            // The length of this subarray is `j - i`. We need to replace `N - j + i` elements to make it continuous.
            ans = Math.min(ans, N - j + i);
        }

        return ans;
        
    }
}