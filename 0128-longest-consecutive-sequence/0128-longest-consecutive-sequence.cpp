class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        set<int>s;
        int ans=0;
        for(int n:nums){
            s.insert(n);
        }
        for(int n:nums){
            if(s.contains(n+1)){
                continue;
            }else{
                int len=1;
                while(s.contains(n-1)){
                    len++;
                    s.erase(n);
                    n=n-1;
                }
                ans=max(ans,len);
            }
        }
        return ans;
    }
};