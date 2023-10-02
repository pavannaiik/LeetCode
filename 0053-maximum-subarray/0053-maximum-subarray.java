class Solution {
    public int maxSubArray(int[] nums) {
        int ans =nums[0];
        int curSum =nums[0];
        for(int i=1;i<nums.length;i++){
            curSum = Math.max(nums[i],curSum+nums[i]);
            if(curSum > ans){
                ans = curSum;
            }
        }
        return ans;
    }
}