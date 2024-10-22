class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        //vector<vector<int>>ans;
        sort(nums.begin(),nums.end());
        return ksum(0,nums.size(),nums,3,0);
        
    }
    vector<vector<int>> ksum(int index, int len,vector<int>& nums, int k,int target ){
        vector<vector<int>>ans;
        if(index >=len){
            return ans;
        }
        if(k==2){
            int i= index, j= len-1;
            while(i<j){
                if(nums[i]+nums[j] ==target){
                    vector<int>temp;
                    temp.push_back(nums[i]);
                    temp.push_back(nums[j]);
                    ans.push_back(temp);
                    while(i<len-1 && nums[i]==nums[i+1]) i++;
                    while(j>0 && nums[j]==nums[j-1]) j--;
                    i++;
                    j--;

                }else if(nums[i]+nums[j] > target){
                    j--;
                }else{
                    i++;
                }
            }
        }else{
            for(int i=index;i<len;i++){
                vector<vector<int>>cur=ksum(i+1, len,nums, k-1, target-nums[i]);
                if(!cur.empty()){
                    for(auto& res:cur){
                        res.insert(res.begin(),nums[i]);
                    }
                    for(auto v:cur){
                        ans.push_back(v);
                    }
                }
                while(i <len-1 && nums[i]==nums[i+1])i++;
            }
        }
        return ans;
    }
};