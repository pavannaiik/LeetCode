class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string>ans;
        backtrack(n,0,0,ans,"");
        return ans;
    }
    void backtrack(int n,int open, int closed, vector<string>&ans, string res){
        if(res.length()==2*n){
            ans.push_back(res);
            return;
        }
        if( open <n){
            backtrack(n, open+1, closed, ans, res+"(");
        }
         if(closed < open){
            backtrack(n, open, closed+1, ans, res+")");
        }
    }
};