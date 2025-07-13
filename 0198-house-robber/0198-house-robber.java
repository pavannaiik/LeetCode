class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n ==0) return 0;
        if(n == 1) return nums[0];
        int dp1 = nums[0];
        int dp2 = Math.max(nums[0], nums[1]);
        for(int i=2;i<n ;i++){
            int t = dp2;
            dp2= Math.max(dp2, dp1+nums[i]);
            dp1 = t;
        }
        return dp2;
    }
}