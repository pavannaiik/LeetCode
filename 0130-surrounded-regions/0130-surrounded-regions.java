class Solution {
    public void solve(char[][] board) {
       int n = board.length;
        int m = board[0].length;
        //go through the first colum and last column
        for(int i=0;i<n;i++){
            dfs(board,i,0);
            dfs(board,i,m-1); 
        }
        //go through first row and last row
        for(int j=0;j<m;j++){
            dfs(board,0,j);
            dfs(board,n-1,j); 
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
    public void dfs(char[][] board, int i, int j){
        if(i<0 || i >= board.length || j <0 || j>=board[0].length || board[i][j]=='X' || board[i][j]=='*'){
            return;
        }
        board[i][j] ='*';
        dfs(board, i, j+1);
        dfs(board, i, j-1);
        dfs(board, i+1, j);
        dfs(board, i-1, j);
    }
}