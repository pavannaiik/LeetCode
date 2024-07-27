class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i=0;i<rows;i++){
            if(grid[i][0]==1)
                dfs(grid, i,0);
            if(grid[i][cols-1]==1)
                dfs(grid,i,cols-1);
        }
        for(int j=0;j<cols;j++){
            if(grid[0][j]==1)
                dfs(grid, 0,j);
            if(grid[rows-1][j]==1)
                dfs(grid,rows-1,j);
        }
        int ans=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(int[][] grid, int i, int j){
        if( i<0 || i>= grid.length || j<0 || j >= grid[0].length||grid[i][j]==0 || grid[i][j]==2){
            return;
        }
        grid[i][j]=2;
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
    }
}