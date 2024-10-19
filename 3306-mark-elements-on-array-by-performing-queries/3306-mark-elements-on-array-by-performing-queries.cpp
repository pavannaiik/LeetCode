class Solution {
public:
    vector<long long> unmarkedSumArray(vector<int>& nums, vector<vector<int>>& queries) {
        long long  sum = 0;
        int n = nums.size();
        
        vector<long long>ans;
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>>pq;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            pq.push({nums[i],i});
        }
        for(vector<int>query:queries){
            sum -= nums[query[0]];
            nums[query[0]]=0;
            while(!pq.empty() && query[1]){
               if(nums[pq.top().second]!=0) {
                    sum-=nums[pq.top().second];
                    nums[pq.top().second]=0;
                    query[1]--;
                }
                pq.pop();
            }
            ans.push_back(sum);
            
        }
        return ans;
    }
};