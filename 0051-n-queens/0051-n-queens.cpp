class Solution {
public:
    vector<vector<string>>ans;
    vector<string>board;
    set<int>colSet;
    set<int>posDia;
    set<int>negDia;
    vector<vector<string>> solveNQueens(int n) {
        board = vector<string>(n, string(n, '.'));
        backtrack(0,n);
        return ans;
    }
    void backtrack(int r, int n){
        if(r==n){
            ans.push_back(board);
            return;
        }
        for(int c=0;c<n;c++){
            if(colSet.contains(c) || posDia.contains(r+c)||negDia.contains(r-c)){
                continue;
            }
            colSet.insert(c);
            posDia.insert(r+c);
            negDia.insert(r-c);
            board[r][c]='Q';
            backtrack(r+1,n);
            colSet.erase(c);
            posDia.erase(r+c);
            negDia.erase(r-c);
            board[r][c]='.';
        }
    }
};