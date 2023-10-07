class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        //go through the first colum and last column
        for(int i=0;i<n;i++){
            dfs(board,i,0,n,m);
            dfs(board,i,m-1,n,m); 
        }
        //go through first row and last row
        for(int j=0;j<m;j++){
            dfs(board,0,j,n,m);
            dfs(board,n-1,j,n,m); 
        }
        // make all O to X and * to O 
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='*'){
                    board[i][j]='O';
                }else{
                    board[i][j]='X';
                }
            }
        }
    }
    public void dfs(char[][] board,int i,int j,int n,int m){
        if(i<0 || i>=n ||j<0 ||j>=m || board[i][j]=='X' || board[i][j]=='*'){
            return;
        }
        board[i][j] = '*';
        dfs(board,i+1,j,n,m);
        dfs(board,i-1,j,n,m);
        dfs(board,i,j+1,n,m);
        dfs(board,i,j-1,n,m);
    }
}