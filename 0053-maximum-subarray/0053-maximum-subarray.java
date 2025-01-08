class Solution {
    public int maxSubArray(int[] nums) {
        int maxSubArraySum =nums[0];
        int curSum = nums[0];
        for(int i=1;i<nums.length;i++){
            curSum = Math.max(nums[i], curSum+nums[i]);
            maxSubArraySum = Math.max(maxSubArraySum, curSum);
        }
        return maxSubArraySum;
    }
}