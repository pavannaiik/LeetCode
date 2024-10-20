class Solution {
public:
    vector<vector<int>>ans;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int>temp;
        recur(candidates, 0,temp,target,0);
        return ans;
    }
    void recur(vector<int>& nums, int index, vector<int>&temp, int target, int sum){
        if(sum==target){
            ans.push_back(temp);
        }
        if(index >= nums.size() || sum>target){
            return;
        }
        for(int i=index;i<nums.size();i++){
            temp.push_back(nums[i]);
            recur(nums, i, temp,target, nums[i]+sum);
            temp.pop_back();
        }
    }
};