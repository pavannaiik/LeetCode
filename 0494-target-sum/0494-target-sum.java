class Solution {
    int count =0;
    public int findTargetSumWays(int[] nums, int target) {
         findWays(nums, target, 0,0);
         return count;

    }
    public void findWays(int nums[], int target, int index, int sum){
        if( index == nums.length){
            if(target ==sum)
                count++;
            return;
        }
        findWays(nums, target, index+1, sum-nums[index]);
        findWays(nums, target, index+1, sum+nums[index]);
}
}