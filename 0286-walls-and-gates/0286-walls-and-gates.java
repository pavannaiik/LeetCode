class Solution {
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public void wallsAndGates(int[][] rooms) {
        int n = rooms.length;
        if (n == 0) return;
        int m = rooms[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == 0) {  // Start DFS from each gate
                    dfs(i, j, n, m, rooms, 0);
                }
            }
        }
    }
    
    public void dfs(int i, int j, int n, int m, int[][] rooms, int dist) {
        for (int k = 0; k < 4; k++) {
            int r = i + dir[k][0];
            int c = j + dir[k][1];
            if (r < 0 || r >= n || c < 0 || c >= m || rooms[r][c] == -1 || rooms[r][c] <= dist + 1) {
                continue;
            }
            rooms[r][c] = dist + 1;
            dfs(r, c, n, m, rooms, dist + 1);
        }
    }
}
