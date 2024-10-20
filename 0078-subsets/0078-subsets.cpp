class Solution {

public:
    vector<vector<int>>ans;
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int>temp;
        recur(nums, 0,temp);
        return ans;
    }
    void recur(vector<int>& nums, int index, vector<int>&temp){
        ans.push_back(temp);
        if(index >= nums.size()){
            return;
        }
        for(int i=index;i<nums.size();i++){
            temp.push_back(nums[i]);
            recur(nums, i+1, temp);
            temp.pop_back();
        }
    }
};