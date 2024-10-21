class Solution {
public:
    int minMeetingRooms(vector<vector<int>>& intervals) {
        if(intervals.size()==0){
            return 0;
        }
        sort(intervals.begin(),intervals.end());
        priority_queue<int,vector<int>,greater<int>>pq;
        int ans=1;
        for(auto it:intervals){
            int end= it[1];
            while(!pq.empty() && it[0]>=pq.top()){
                pq.pop();
            }
            pq.push(end);
            if(pq.size() >ans){
                ans=pq.size();
            }
        }
        return ans;
    }
};