class Solution {
    public boolean canJump(int[] nums) {
        int ans =0, n = nums.length;
        int curFar=0,curEnd =0;
        for(int i=0;i<n-1;i++){
            curFar = Math.max(curFar,i+nums[i]);
                if(i==curEnd){
                    ans++;
                    curEnd=curFar;
                }
        }
        if(curEnd<n-1){
            return false;
        }
        return true;
    }
}