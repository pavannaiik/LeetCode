class Solution {
    private final int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}}; // Right, Left, Down, Up

    public int findMaxFish(int[][] grid) {
        int maxFish = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] != 0) {
                    maxFish = Math.max(maxFish, dfs(grid, i, j));
                }
            }
        }
        return maxFish;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int fish = grid[i][j];
        grid[i][j] = 0; // Mark as visited
        
        for (int[] dir : directions) {
            fish += dfs(grid, i + dir[0], j + dir[1]);
        }
        return fish;
    }
}
