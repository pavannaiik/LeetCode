class Solution {
    int[][] memo;
    int total;
    public int findTargetSumWays(int[] nums, int target) {
        total = Arrays.stream(nums).sum();
        memo = new int[nums.length][2*total+1];
        for(int[] arr:memo){
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
        return getTargetSumCount(nums, target, 0, 0);
    }
    public int getTargetSumCount(int[] nums, int target, int index, int curSum){
        if(index == nums.length){
            if(curSum==target) return 1;
            else return 0;
        }
        if(memo[index][total+curSum] != Integer.MIN_VALUE){
            return memo[index][total+curSum];
        }
        int add = getTargetSumCount(nums, target, index+1, curSum+nums[index]);
        int subtract = getTargetSumCount(nums, target, index+1, curSum-nums[index]);
        memo[index][total+curSum] = add+subtract;
        return memo[index][total+curSum];
    }
}