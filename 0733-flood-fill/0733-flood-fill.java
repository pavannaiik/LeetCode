class Solution {
    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {

        dfs(grid, sr, sc, color, grid[sr][sc]);
        return grid;
    }
    public void dfs(int[][] grid, int i, int j, int color, int pixel){
        if(i <0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=pixel || grid[i][j]==color){
            return;
        }
        grid[i][j]=color;
        dfs(grid, i, j+1,color,pixel);
        dfs(grid, i, j-1,color,pixel);
        dfs(grid, i+1, j,color,pixel);
        dfs(grid, i-1, j,color,pixel);
    }
}