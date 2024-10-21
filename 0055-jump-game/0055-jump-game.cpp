class Solution {
public:
    bool canJump(vector<int>& nums) {
        int  n = nums.size();
        int curFar=0,curEnd =0;
        for(int i=0;i<n-1;i++){
            curFar = max(curFar,i+nums[i]);
                if(i==curEnd){
                    curEnd=curFar;
                }
        }
        if(curEnd<n-1){
            return false;
        }
        return true;
    }
};