class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        int n= s.length();
        unordered_set<string>words(wordDict.begin(),wordDict.end());
        vector<bool>dp(n+1,false);
        dp[0]=true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                //if characters till j is segmented
                //then only we can check for the other characters
                if(dp[j] && words.count(s.substr(j,i-j))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];

    }
};