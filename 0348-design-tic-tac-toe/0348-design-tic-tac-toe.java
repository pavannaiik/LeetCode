class TicTacToe {
    private int[][] board ;
    private int n;
    public TicTacToe(int n) {
        board = new int[n][n];
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        //put player in the given place
        board[row][col] = player;
        if(rowCheck(row,col,player) || columnCheck(row,col,player)|| diagonalCheck(row,col,player)||
           antiDiagonalCheck(row,col,player)){
            return player;
        }
        return 0;
    }
    public boolean rowCheck(int row,int col,int player){
        for(int i=0;i<n;i++){
            if(board[row][i]!=player){
                return false;
            }
        }
        return true;
    }
    public boolean columnCheck(int row,int col,int player){
        for(int i=0;i<n;i++){
            if(board[i][col]!=player){
                return false;
            }
        }
        return true;
    }
    public boolean diagonalCheck(int row,int col,int player){
        for(int i=0;i<n;i++){
            if(board[i][i]!=player){
                return false;
            }
        }
        return true;
    }
    public boolean antiDiagonalCheck(int row,int col,int player){
        for(int i=0;i<n;i++){
            if(board[i][n-i-1]!=player){
                return false;
            }
        }
        return true;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */