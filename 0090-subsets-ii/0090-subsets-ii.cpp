class Solution {
public:
    vector<vector<int>>ans;
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        vector<int>t;
        recur(nums, 0, t);
        return ans;

    }
    void recur(vector<int>&nums, int index, vector<int>&temp){
        ans.push_back(temp);
        if(index>=nums.size()){
            return;
        }
        for(int i=index;i<nums.size();i++){
            if(i!=index && nums[i]==nums[i-1]){
                continue;
            }
            temp.push_back(nums[i]);
            recur(nums, i+1,temp);
            temp.pop_back();
        }
    }
};