class Solution {
    public int findMaxFish(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0){
                    int fishes = dfs(grid, i, j, n, m);
                    ans = Math.max(ans, fishes);
                }
            }
        }
        return ans;
    }
    public int dfs(int[][] grid, int i, int j, int n, int m){
        if(i < 0|| i>=n || j < 0 || j >=m || grid[i][j]==0){
            return 0;
        }
        int fishes = grid[i][j];
        grid[i][j]=0;
        // Explore all four directions
        fishes += dfs(grid, i, j - 1, n, m); // Left
        fishes += dfs(grid, i, j + 1, n, m); // Right
        fishes += dfs(grid, i - 1, j, n, m); // Up
        fishes += dfs(grid, i + 1, j, n, m); // Down
        
        return fishes;
    }
}