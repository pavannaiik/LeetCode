class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int>LIS(nums.size(),1);
        int ans=1;
        for(int i=1;i<nums.size();i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j])
                    LIS[i]=max(LIS[i],LIS[j]+1);
            }
            ans=max(ans,LIS[i]);
        }
        return ans;
    }
};