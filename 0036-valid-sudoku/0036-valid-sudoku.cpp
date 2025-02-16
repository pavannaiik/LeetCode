class Solution {
public:
    bool isValid(vector<vector<char>>& board, int row, int col, char ch){
        int n = board.size();
        int m = board[0].size();
        
        for(int p=0;p<m;p++){
            if(p!=col){
                if(ch==board[row][p]) return false;
            }
            if(p!=row){
                if(ch==board[p][col]) return false;
            }
        }
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;
        for (int i = startRow; i < startRow + 3; i++) 
            for (int j = startCol; j < startCol + 3; j++) 
                if ((i != row || j != col) && board[i][j] == ch) 
                    return false;
        return true;
    }
    bool isValidSudoku(vector<vector<char>>& board) {
        int n=board.size(),m=board[0].size();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char ch = board[i][j];
                if(ch!='.'){
                    if(!isValid(board, i , j, ch)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
};