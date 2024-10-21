class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        sort(intervals.begin(),intervals.end());
        int preEnd=intervals[0][1];
        int count=0;
        for(int i=1;i<intervals.size();i++){
            if(preEnd>intervals[i][0]){
                count++;
                preEnd=min(preEnd,intervals[i][1]);
            }else{
                preEnd=intervals[i][1];
            }
        }
        return count;
    }
};