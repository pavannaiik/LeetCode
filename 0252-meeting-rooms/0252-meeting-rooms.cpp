class Solution {
public:
    bool canAttendMeetings(vector<vector<int>>& intervals) {
        if(intervals.size()==0){
            return true;
        }
        sort(intervals.begin(),intervals.end());
        int preEnd=intervals[0][1];
        for(int i=1;i<intervals.size();i++){
            if(preEnd>intervals[i][0]){
                return false;
            }else{
                preEnd=intervals[i][1];
            }
        }
        return true;
    }
};