class Solution {

    int dx[] = {-1,0,0,1};
    int dy[] = {0,-1,1,0};
    public void dfs(char[][] grid, boolean[][] visited, int n, int m, int i, int j){
        visited[i][j] = true;

        for(int k=0; k<4; k++){
            int newx = i + dx[k];
            int newy = j + dy[k];
            if(newx >=0 && newy >=0 && newx < n && newy < m && !visited[newx][newy] && grid[newx][newy] == '1'){
                dfs(grid, visited, n, m, newx, newy);
            }

        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for(int i = 0; i< n ;i++){
            for(int j = 0 ; j<m ; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                dfs(grid, visited, n, m, i, j);
                count++;
                }
            }
        }
        return count;
    }
}