class Solution {
    int cnt=0;
    public int findTargetSumWays(int[] nums, int target) {
         getTargetSum(nums, target, 0, 0);
         return cnt;
    }
    public void getTargetSum(int[] nums, int target, int index, int curSum){
        if(index==nums.length){
            if(curSum==target) cnt++;
            return;
        }
        getTargetSum(nums, target, index+1, curSum+nums[index]);
        getTargetSum(nums, target, index+1, curSum-nums[index]);
    }
}