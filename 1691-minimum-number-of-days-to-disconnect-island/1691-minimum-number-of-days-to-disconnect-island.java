class Solution {
    int time = 1;
    private boolean art = false;
    public static final int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public int minDays(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        // Step 1: Check if the grid is already disconnected
        if (countComponents(grid, n, m) > 1 ||countComponents(grid, n, m) == 0  ) {
            return 0;
        }
        
        int[][] timeOfInsertion = new int[n][m];
        int[][] lowTime = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        time = 1; // Reset time for new run
        art = false; // Reset articulation flag
        
        // Step 2: Run DFS to find articulation points
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, -1, -1, n, m, grid, timeOfInsertion, lowTime, visited);
                }
            }
        }
        if(time ==2) return 1;
        
        // Step 3: Determine the result based on articulation points
        return art ? 1 : 2;
    }
    
    public void dfs(int i, int j, int parentI, int parentJ, int n, int m, int[][] grid, 
                    int[][] timeOfInsertion, int[][] lowTime, boolean[][] visited) {
        visited[i][j] = true;
        timeOfInsertion[i][j] = lowTime[i][j] = time++;
        int child = 0;
        
        for (int k = 0; k < 4; k++) {
            int r = i + dir[k][0];
            int c = j + dir[k][1];
            
            if (!isValid(r, c, n, m) || grid[r][c] == 0) {
                continue;
            }
            
            if (!visited[r][c]) {
                child++;
                dfs(r, c, i, j, n, m, grid, timeOfInsertion, lowTime, visited);
                lowTime[i][j] = Math.min(lowTime[i][j], lowTime[r][c]);
                
                // Check if the current node is an articulation point
                if ((parentI != -1 || parentJ != -1) && lowTime[r][c] >= timeOfInsertion[i][j]) {
                    art = true;
                }
            } else if (!(r == parentI && c == parentJ)) {
                lowTime[i][j] = Math.min(lowTime[i][j], timeOfInsertion[r][c]);
            }
        }
        
        if (parentI == -1 && parentJ == -1 && child > 1) {
            art = true;
        }
    }
    
    public boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    // Helper function to count connected components
    private int countComponents(int[][] grid, int n, int m) {
        boolean[][] visited = new boolean[n][m];
        int components = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfsComponent(i, j, n, m, grid, visited);
                    components++;
                }
            }
        }
        return components;
    }
    
    // DFS for counting components
    private void dfsComponent(int i, int j, int n, int m, int[][] grid, boolean[][] visited) {
        if (!isValid(i, j, n, m) || grid[i][j] == 0 || visited[i][j]) return;
        visited[i][j] = true;
        
        for (int[] d : dir) {
            dfsComponent(i + d[0], j + d[1], n, m, grid, visited);
        }
    }
}
