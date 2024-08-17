class Solution {
    int min = Integer.MAX_VALUE;
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        Integer[][] dp = new Integer[row][col];
        for(int i=0;i<matrix[0].length;i++){
            min = Math.min(min, minFallingPath(matrix,0, i, dp));
        }
        return min;
    }
    public int minFallingPath(int[][] matrix, int row, int col, Integer[][] dp){
        if(col <0 || col >= matrix[0].length){
            return Integer.MAX_VALUE;
        }
        if(row == matrix.length-1){
            return matrix[row][col];
        }
        if(dp[row][col] != null){
            return dp[row][col];
        }
        int downLeft = minFallingPath(matrix, row+1, col-1,dp);
        int down = minFallingPath(matrix, row+1, col,dp);
        int downRight = minFallingPath(matrix, row+1, col+1,dp);

        dp[row][col] =  matrix[row][col] + Math.min(down,Math.min(downLeft,downRight));
        return dp[row][col];
    }
}