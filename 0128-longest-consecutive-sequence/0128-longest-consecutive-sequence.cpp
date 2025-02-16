class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int>set;
        for(int n:nums) set.insert(n);
        int len =0;
        for(int n:set){
            int curNum = n;
            if(set.contains(n+1)){
                continue;
            }
            int curLen =0;
            while(set.contains(curNum)){
                curLen++;
                curNum -= 1;
            }
            len = max(len, curLen);
        }
        return len;
    }
};