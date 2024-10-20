class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        int totalJobs = tasks.size();
        int maxCount = 0;
        int X=0;
       unordered_map<char,int>map;
        for(char c:tasks){
            map[c]++;
            maxCount = max(maxCount,map[c]);
        }
        for(auto m:map){
            if(m.second==maxCount) X++;
        }
        return max(totalJobs, (maxCount-1)*(n+1)+X);
    }
};