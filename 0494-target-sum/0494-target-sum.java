class Solution {
    int total =0;
    public int findTargetSumWays(int[] nums, int target) {
        total = Arrays.stream(nums).sum();  
        int[][] memo = new int[nums.length][2*total+1];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return findWays(nums, target, 0,0, memo);

    }
    public int findWays(int nums[], int target, int index, int sum, int[][] memo){
        if( index == nums.length){
            if(target ==sum)
                return 1;
            else return 0;
        }else{
            if(memo[index][sum+total] != Integer.MIN_VALUE){
                return memo[index][sum+total];
            }
            int subtract = findWays(nums, target, index+1, sum-nums[index], memo);
            int add = findWays(nums, target, index+1, sum+nums[index], memo);
            memo[index][sum+total] = add+subtract;
            return memo[index][sum+total];
        }
        
}
}