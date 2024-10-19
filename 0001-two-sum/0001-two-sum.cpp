class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int>ans(2);
        map<int,int>map;
        for(int i=0;i<nums.size();i++){
            if(map.contains(target-nums[i])){
                ans[0]=map.at(target-nums[i]);
                ans[1]=i;
                return ans;
            }
            map.insert({nums[i],i});
        }
        return ans;
    }
};