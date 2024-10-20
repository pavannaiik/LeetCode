class Solution {
public:
    vector<vector<int>>ans;
    vector<vector<int>> permute(vector<int>& nums) {
        vector<int>temp;
        vector<bool> used(nums.size(), false);
        recur(nums, 0, temp, used);
        return ans;
    }
    void recur(vector<int>& nums, int index, vector<int>&temp,vector<bool>&used){
        //ans.push_back(temp);
        if(index == nums.size()){
            ans.push_back(temp);
        }else{
            for(int i=0;i<nums.size();i++){
                if(!used[i]){
                    used[i]=true;
                    temp.push_back(nums[i]);
                    recur(nums, index+1, temp,used);
                    temp.pop_back();
                    used[i]=false;
                }
            }
        }
        
    }
};