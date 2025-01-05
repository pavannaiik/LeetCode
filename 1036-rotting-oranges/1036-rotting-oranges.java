class Solution {
    public int orangesRotting(int[][] grid) {
        int ans =2;
        int n = grid.length, m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    dfs(grid, i, j, n, m, 2);
                }
            }
        }
       // System.out.println(grid);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return -1;
                }
                ans = Math.max(ans, grid[i][j]);
            }
        }
        return ans-2;

    }
    public void dfs(int[][] grid, int i, int j, int n, int m, int time){
        if(i<0 || i>=n || j<0 ||j >=m|| grid[i][j]==0){
            return;
        }
        if(grid[i][j] > 1 && grid[i][j] < time) return;
        grid[i][j] = time;

        dfs(grid, i, j+1, n, m, time+1);
        dfs(grid, i, j-1, n, m, time+1);
        dfs(grid, i+1, j, n, m, time+1);
        dfs(grid, i-1, j, n, m, time+1);
    }
}