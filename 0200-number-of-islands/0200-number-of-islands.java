class Solution {
      int numberOfIslands =0;
    public int numIslands(char[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    bfs(grid,i,j);
                    numberOfIslands++;
                }
            }
        }
        return numberOfIslands;
        
    }
    public void bfs(char[][] grid,int i, int j) {
        if(i>=grid.length || i < 0 || j>=grid[0].length || j<0 ||  grid[i][j]=='0' ){
            return;
        }
        grid[i][j]='0';
        bfs(grid,i,j+1);
        bfs(grid,i,j-1);
        bfs(grid,i-1,j);
        bfs(grid,i+1,j);
        return;
    }
}