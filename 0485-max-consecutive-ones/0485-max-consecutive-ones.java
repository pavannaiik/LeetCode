class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans =0;
        int cur = nums[0]==1?1:0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==1 && nums[i]==nums[i-1]){
                cur++;
            }else{
                ans=Math.max(ans,cur);
                cur=nums[i]==1?1:0;
            }
            ans=Math.max(ans,cur);
        }
        return Math.max(ans,cur);
    }
}