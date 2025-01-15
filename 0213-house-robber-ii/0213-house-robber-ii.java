class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        int robWFirst = robHouse(nums, 0, nums.length-1);
        int robWOFirst = robHouse(nums, 1, nums.length);
        return Math.max(robWFirst, robWOFirst);
    }
    public int robHouse(int[] nums, int index, int n){
        int[] dp = new int[n];
        if(index ==0){
            dp[0]=nums[0];
            dp[1]=Math.max(nums[0], nums[1]);
        }else{
            dp[0]=0;
            dp[1]=nums[1];
        }
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[n-1];
    }
}