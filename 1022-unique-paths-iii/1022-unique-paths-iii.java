class Solution {
    int ans=0;
    int emptyCells=0;
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int start=0, end=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    start=i;
                    end=j;
                }else if(grid[i][j]==0){
                    emptyCells++;
                }
            }
        }
        dfs(grid, start,end, n, m,-1);
        return ans;
    }
    public void dfs(int[][] grid, int i, int j, int n, int m, int count){
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]==-1){
            return;
        }
        if(grid[i][j]==2){
            if(emptyCells==count){
                ans++;
            }
            return ;
        }
        grid[i][j] = -1;
        dfs(grid, i,j+1, n, m, count+1);
        dfs(grid, i,j-1, n, m, count+1);
        dfs(grid, i+1,j, n, m, count+1);
        dfs(grid, i-1,j, n, m, count+1);
        grid[i][j] = 0;
    }
}