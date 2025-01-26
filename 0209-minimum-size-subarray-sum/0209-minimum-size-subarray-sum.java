class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen=Integer.MAX_VALUE;
        int sum=0;
        int start=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(sum>=target){
                minLen=Math.min(minLen,i-start+1);
                sum=sum-nums[start++];
            }
        }
       return minLen==Integer.MAX_VALUE?0:minLen;
    }
}