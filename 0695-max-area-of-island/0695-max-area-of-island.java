class Solution {
    int maxArea =0;
    public int maxAreaOfIsland(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    maxArea = Math.max(maxArea,bfs(grid,i,j));
                }
            }
        }
        return maxArea;
    }
    public int bfs(int[][] grid, int i ,int j){
        if(i<0 || j<0 || i>=grid.length || j>= grid[0].length || grid[i][j]==0){
            return 0;
        }
        grid[i][j]=0;
        return 1+ bfs(grid,i,j-1)+bfs(grid,i,j+1)+ bfs(grid,i-1,j)+bfs(grid,i+1,j);
    }
}