class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(),intervals.end());
        int start=intervals[0][0];
        int end=intervals[0][1];
        vector<vector<int>>ans;
        for(auto it:intervals){
            if(it[0]>end){
                vector<int>t(2);
                t[0]=start;
                t[1]=end;
                ans.push_back(t);
                start=it[0];
                end=it[1];
            }else{
                start=min(start,it[0]);
                end=max(end,it[1]);
            }
        }
        vector<int>t(2);
        t[0]=start;
        t[1]=end;
        ans.push_back(t);
        return ans;
    }
};