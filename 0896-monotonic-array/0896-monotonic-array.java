class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length==1 || nums.length ==2) return true;
        boolean increasing = true;
        boolean decreasing = true;
            for(int i=1;i<nums.length;i++){
                if(nums[i] < nums[i-1] ) increasing = false;
                if(nums[i] > nums[i-1] ) decreasing = false;
            }
        return decreasing || increasing;
    }
}