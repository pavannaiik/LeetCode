class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char num = board[row][col];
                if (num != '.') { 
                    if (!isValid(board, row, col, num)) 
                        return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (i != col && board[row][i] == num) 
                return false;
            if (i != row && board[i][col] == num)
                return false;
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        System.out.println(startRow);
        System.out.println(startCol);
        for (int i = startRow; i < startRow + 3; i++) 
            for (int j = startCol; j < startCol + 3; j++) 
                if ((i != row || j != col) && board[i][j] == num) 
                    return false;
        return true;
    }
}