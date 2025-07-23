class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int curMax = nums[0], curMin = nums[0];
        int maxProd = curMax;
        for(int i=1;i<n;i++){
            int temp =curMax * nums[i];
            curMax = Math.max(nums[i], Math.max(temp, nums[i]*curMin));
            curMin = Math.min(nums[i], Math.min(temp, nums[i]*curMin));
            maxProd = Math.max(maxProd, curMax);
        }
        return maxProd;
    }
}