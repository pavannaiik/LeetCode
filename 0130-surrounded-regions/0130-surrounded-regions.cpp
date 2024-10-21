class Solution {
public:
    void solve(vector<vector<char>>& board) {
        int n = board.size();
        int m = board[0].size();
        //go through first col and last col if the cell is
        // O then all the connected O cell wont be sorrounded
        //so we mark them with *
        //same with first and last row
        for(int i=0;i<n;i++){
            dfs(board, i,0);
            dfs(board, i,m-1);
        }
        for(int i=0;i<m;i++){
            dfs(board,0,i);
            dfs(board,n-1,i);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='*'){
                    board[i][j]='O';
                }else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
    void dfs(vector<vector<char>>& board, int i, int j){
        if(i<0 || i>=board.size() || j<0 || j>=board[0].size() || board[i][j]=='X' || board[i][j]=='*'){
            return ;
        }
        board[i][j]='*';
        dfs(board,i,j+1);
        dfs(board,i,j-1);
        dfs(board,i-1,j);
        dfs(board,i+1,j);
    }
};