class Solution {
public:
    bool canJump(vector<int>& nums) {
        //goal is to reach last index
        int goal =nums.size()-1;
        for(int i=nums.size()-2;i>=0;--i){
            if(i+nums[i] >= goal){
                goal=i;
            }
        }
        return goal>0?false:true;
    }
};