class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
       unordered_map<int,int>map;
       vector<int>v;
       for(int num:nums){
         map[num]++;
       }
       priority_queue<pair<int,int>>pq;
       for(auto it:map){
        pq.push({it.second,it.first});
       }
       while(k--){
            auto [elem, count] = pq.top();
            v.push_back(count);
            pq.pop();
       }
       return v;

    }
};