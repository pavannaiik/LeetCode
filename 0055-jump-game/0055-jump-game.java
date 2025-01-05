class Solution {
    public boolean canJump(int[] nums) {
        //at each step take whats the max jump u can take 
        int curJumps=0;
        if(nums.length==1) return true;
        if(nums[0]==0) return false;
        for(int i=0;i<nums.length-1;i++){
            curJumps--;
            if(nums[i] > curJumps){
                curJumps=nums[i];
            }
            if(curJumps==0) return false;
        }
        if(curJumps>0) return true;
        return false;
    }
}