class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;

                int num = c - '1';  // Convert character '1'-'9' to index 0-8
                int boxIndex = (i / 3) * 3 + (j / 3);  // Calculate box index (0-8)

                if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                    return false;  // Duplicate found
                }

                rows[i][num] = true;
                cols[j][num] = true;
                boxes[boxIndex][num] = true;
            }
        }
        return true;
    }
}