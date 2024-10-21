class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>>ans;
        int start = newInterval[0],end=newInterval[1];
        for(auto it:intervals){
            if(it[0]>end){
                vector<int>temp(2);
                temp[0]=start;
                temp[1]=end;
                ans.push_back(temp);
                start=it[0];
                end=it[1];
            }else{
                if(start>it[1]){
                    ans.push_back(it);
                }else{
                    start=min(start,it[0]);
                    end=max(end,it[1]);
                }
            }
        }
        vector<int>temp(2);
        temp[0]=start;
        temp[1]=end;
        ans.push_back(temp);
        return ans;
    }
};