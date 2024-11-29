class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int maxSofar = 0;
        int maxi=INT_MIN;
        for(int i=0;i<nums.size();i++){
            maxSofar = max(maxSofar+nums[i], nums[i]);
            maxi=max(maxi,maxSofar);
        }
        return maxi;
    }
};