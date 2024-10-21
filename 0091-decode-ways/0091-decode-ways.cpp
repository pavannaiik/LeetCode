class Solution {
public:
    map<int,int>memo;
    int numDecodings(string s) {
        return recursiveMemo(0,s);
    }
    int recursiveMemo(int index, string s){
        if(memo.find(index)!=memo.end()){
            return memo[index];
        }
        if(index==s.length()){
            return 1;
        }
        if(s[index]=='0') return 0;
        if(index==s.length()-1) return 1;
        int ans =recursiveMemo(index+1, s);
        if(stoi(s.substr(index,2)) <= 26){
            ans += recursiveMemo(index+2,s);
        }
        memo[index]=ans;
        return ans;
    }
};