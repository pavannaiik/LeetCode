class Solution {
    public int maxProduct(int[] nums) {
        int curMax=nums[0];
        int curMin = nums[0];
        int max =curMax;
        for(int i=1;i<nums.length;i++){
            int temp = curMax;
            curMax = Math.max(nums[i],Math.max(nums[i]*curMax,nums[i]*curMin));
            curMin = Math.min(nums[i],Math.min(nums[i]*temp,nums[i]*curMin));
            max = Math.max(curMax,max);
        }
        return max;
    }
}